package com.mnov34.quiz.controllers;

import com.mnov34.quiz.models.Question;
import com.mnov34.quiz.services.QuizService;
import com.mnov34.quiz.services.ScoreService;
import com.mnov34.quiz.services.impl.QuizServiceImpl;
import com.mnov34.quiz.services.impl.ScoreServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
@WebServlet
public class QuizController extends HttpServlet {
    private final QuizService quizService = new QuizServiceImpl();
    private final ScoreService scoreService = new ScoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questions = quizService.loadQuiz();
        request.setAttribute("questions", questions);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/quiz.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] userAnswers = request.getParameterValues("answers");
        int playerId = Integer.parseInt(request.getParameter("playerId"));
        int score = quizService.calculateScore(userAnswers);
        scoreService.saveScore(playerId, score);

        request.setAttribute("score", score);
        request.setAttribute("averageScore", scoreService.getAverageScoreByPlayerId(playerId));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/results.jsp");
        dispatcher.forward(request, response);
    }
}
