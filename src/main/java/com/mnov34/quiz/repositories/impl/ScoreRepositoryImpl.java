package com.mnov34.quiz.repositories.impl;

import com.mnov34.quiz.config.Database;
import com.mnov34.quiz.repositories.ScoreRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class ScoreRepositoryImpl implements ScoreRepository {
    private static final String SQL_INSERT_SCORE =
            "INSERT INTO score (player_id, score_value, play_date) VALUES (?, ?, NOW())";
    private static final String SQL_SELECT_SCORES =
            "SELECT score_value FROM score WHERE player_id = ?";

    @Override
    public void insertScore(int playerId, int score) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_SCORE)) {
            preparedStatement.setInt(1, playerId);
            preparedStatement.setInt(2, score);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> findAllScoresByPlayer(int playerId) {
        List<Integer> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_SCORES)) {
            preparedStatement.setInt(1, playerId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(resultSet.getInt("score_value"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
