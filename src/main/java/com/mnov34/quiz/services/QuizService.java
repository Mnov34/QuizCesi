package main.java.com.mnov34.quiz.services;

import main.java.com.mnov34.quiz.models.Question;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface QuizService {
    List<Question> loadQuiz();
}
