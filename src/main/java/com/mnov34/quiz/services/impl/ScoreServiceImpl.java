package com.mnov34.quiz.services.impl;

import com.mnov34.quiz.repositories.ScoreRepository;
import com.mnov34.quiz.repositories.impl.ScoreRepositoryImpl;
import com.mnov34.quiz.services.ScoreService;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository = new ScoreRepositoryImpl();

    @Override
    public void saveScore(int playerId, int score) {
        scoreRepository.insertScore(playerId, score);
    }

    @Override
    public List<Integer> getScoresByPlayerId(int playerId) {
        return scoreRepository.findAllScoresByPlayer(playerId);
    }

    @Override
    public double getAverageScoreByPlayerId(int playerId) {
        List<Integer> scores = getScoresByPlayerId(playerId);
        if (scores.isEmpty()) return 0.0;

        double total = 0.0;
        for (int s : scores) total += s;

        return total / scores.size();
    }
}
