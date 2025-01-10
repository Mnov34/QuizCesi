package com.mnov34.quiz.repositories;

import com.mnov34.quiz.models.Question;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface QuizRepository {
    List<Question> getAllQuestionsWithAnswers();
}
