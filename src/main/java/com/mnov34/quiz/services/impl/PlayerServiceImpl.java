package com.mnov34.quiz.services.impl;

import com.mnov34.quiz.models.Player;
import com.mnov34.quiz.repositories.PlayerRepository;
import com.mnov34.quiz.repositories.impl.PlayerRepositoryImpl;
import com.mnov34.quiz.services.PlayerService;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository = new PlayerRepositoryImpl();

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    @Override
    public void createPlayer(Player player) {
        playerRepository.insert(player);
    }
}
