package com.mnov34.quiz.repositories;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface ScoreRepository {
    void insertScore(int playerId, int score);

    List<Integer> findAllScoresByPlayer(int playerId);
}
