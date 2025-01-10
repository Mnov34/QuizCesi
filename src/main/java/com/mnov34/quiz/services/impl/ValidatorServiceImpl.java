package com.mnov34.quiz.services.impl;

import com.mnov34.quiz.models.Answer;
import com.mnov34.quiz.services.ValidatorService;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public Boolean isAnswerCorrect(List<Answer> answers, String userInput) {
        for (Answer answer : answers) {
            if (answer.isCorrect()
                    && answer.getAnswerText().toLowerCase().startsWith(userInput.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
