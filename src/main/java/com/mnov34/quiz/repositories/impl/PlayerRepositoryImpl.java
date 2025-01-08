package main.java.com.mnov34.quiz.repositories.impl;

import main.java.com.mnov34.quiz.config.Database;
import main.java.com.mnov34.quiz.models.Player;
import main.java.com.mnov34.quiz.repositories.PlayerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class PlayerRepositoryImpl implements PlayerRepository {

    private static final String SQL_SELECT_ALL_PLAYERS =
            "SELECT id, username FROM players";
    private static final String SQL_SELECT_PLAYER_BY_ID =
            "SELECT id, username FROM players WHERE id = ?";
    private static final String SQL_SELECT_PLAYER_BY_USERNAME =
            "SELECT id, username FROM players WHERE username = ?";
    private static final String SQL_INSERT_PLAYER =
            "INSERT INTO players (username) VALUES (?)";

    @Override
    public List<Player> findAll() {
        List<Player> players = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PLAYERS)) {

            while (resultSet.next()) {
                Player player = new Player();
                player.setId(resultSet.getInt("id"));
                player.setUsername(resultSet.getString("username"));
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public Player findById(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PLAYER_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Player player = new Player();
                    player.setId(resultSet.getInt("id"));
                    player.setUsername(resultSet.getString("username"));
                    return player;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Player findByUsername(String username) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PLAYER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Player player = new Player();
                    player.setId(resultSet.getInt("id"));
                    player.setUsername(resultSet.getString("username"));
                    return player;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Player player) {
        try (Connection connection = Database.getConnection()) {

            if (findByUsername(player.getUsername()) != null) {
                return;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PLAYER, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, player.getUsername());
                preparedStatement.executeUpdate();

                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        int newId = resultSet.getInt(1);
                        player.setId(newId);
                    }
                }
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
