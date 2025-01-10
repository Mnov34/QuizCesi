package com.mnov34.quiz.services;

import com.mnov34.quiz.models.Player;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface PlayerService {
    List<Player> getAllPlayers();

    Player getPlayerById(int id);

    Player getPlayerByUsername(String username);

    void createPlayer(Player player);
}
