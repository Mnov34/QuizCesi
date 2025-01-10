package com.mnov34.quiz.services.impl;

import com.mnov34.quiz.models.Answer;
import com.mnov34.quiz.models.Player;
import com.mnov34.quiz.models.Question;
import com.mnov34.quiz.services.*;

import java.util.List;
import java.util.Scanner;

/**
 * Orchestrates the entire quiz flow, including:
 * - Prompting/creating a Player
 * - Showing old scores/average
 * - Running the quiz
 * - Saving the new score
 * - Showing the updated average
 *
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class GameServiceImpl implements GameService {
    private final QuizService quizService;
    private final ValidatorService validatorService;
    private final PlayerService playerService;
    private final ScoreService scoreService;
    private final LoggingService LOG;

    public GameServiceImpl(QuizService quizService,
                           ValidatorService validatorService,
                           PlayerService playerService,
                           ScoreService scoreService,
                           LoggingService LOG) {
        this.quizService = quizService;
        this.validatorService = validatorService;
        this.playerService = playerService;
        this.scoreService = scoreService;
        this.LOG = LOG;
    }

    @Override
    public void runGame() {
        List<Question> questions = quizService.loadQuiz();
        int score = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Quiz! Please enter your username:");
            String username = scanner.nextLine().trim();

            Player existingPlayer = playerService.getPlayerByUsername(username);
            if (existingPlayer == null) {
                // Create the new player record
                Player newPlayer = new Player();
                newPlayer.setUsername(username);
                playerService.createPlayer(newPlayer);
                existingPlayer = newPlayer;
                System.out.println("Hello, " + username + "! We have created a new account for you.");
            } else {
                System.out.println("Welcome back, " + existingPlayer.getUsername() + "!");
            }

            List<Integer> oldScores = scoreService.getScoresByPlayerId(existingPlayer.getId());
            if (!oldScores.isEmpty()) {
                double oldAvg = scoreService.getAverageScoreByPlayerId(existingPlayer.getId());
                System.out.printf("You have played %d times. Your average score is %.2f.%n",
                        oldScores.size(), oldAvg);
            } else {
                System.out.println("This seems to be your first game!");
            }

            for (Question question : questions) {
                System.out.println("\n" + question.getName());

                for (Answer ans : question.getAnswers())
                    System.out.println("\t->  " + ans.getAnswerText());


                System.out.print("Your choice: ");
                String userInput = scanner.nextLine().trim();

                while (userInput.isEmpty()) userInput = scanner.nextLine().trim();

                if (validatorService.isAnswerCorrect(question.getAnswers(), userInput)) {
                    score++;
                    System.out.println("Correct! +1 point.");
                } else System.out.println("Wrong answer.");
            }
            System.out.printf("%nCongratulations! You finished the quiz. Your score: %d/%d%n",
                    score, questions.size());

            scoreService.saveScore(existingPlayer.getId(), score);

            double newAvg = scoreService.getAverageScoreByPlayerId(existingPlayer.getId());
            System.out.printf("Your new average score is now %.2f.%n", newAvg);
        }

    }
}
