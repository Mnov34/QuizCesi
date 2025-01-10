package com.mnov34.quiz;

import com.mnov34.quiz.services.*;
import com.mnov34.quiz.services.impl.*;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class Main {
    public static void main(String[] args) {
        ValidatorService validatorService = new ValidatorServiceImpl();
        QuizService quizService = new QuizServiceImpl();
        PlayerService playerService = new PlayerServiceImpl();
        ScoreService scoreService = new ScoreServiceImpl();
        LoggingService loggingService = LoggingServiceImpl.getInstance();

        GameService gameService = new GameServiceImpl(
                quizService, validatorService,
                playerService, scoreService, loggingService);

        gameService.runGame();
    }
}