package main.java.com.mnov34.quiz.repositories;

import main.java.com.mnov34.quiz.models.Player;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface PlayerRepository {
    List<Player> findAll();
    Player findById(int id);
    Player findByUsername(String username);
    void insert(Player player);
}
