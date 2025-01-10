package com.mnov34.quiz.services;

import com.mnov34.quiz.models.Answer;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public interface ValidatorService {
    Boolean isAnswerCorrect(List<Answer> answers, String userInput);
}
