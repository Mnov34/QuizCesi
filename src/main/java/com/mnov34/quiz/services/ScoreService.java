package main.java.com.mnov34.quiz.services;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface ScoreService {
    void saveScore(int playerId, int score);

    List<Integer> getScoresByPlayerId(int playerId);

    double getAverageScoreByPlayerId(int playerId);
}
