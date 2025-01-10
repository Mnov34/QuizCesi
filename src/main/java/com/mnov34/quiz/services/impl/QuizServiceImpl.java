package com.mnov34.quiz.services.impl;

import com.mnov34.quiz.models.Answer;
import com.mnov34.quiz.models.Question;
import com.mnov34.quiz.repositories.QuizRepository;
import com.mnov34.quiz.repositories.impl.QuizRepositoryImpl;
import com.mnov34.quiz.services.QuizService;

import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository = new QuizRepositoryImpl();

    @Override
    public List<Question> loadQuiz() {
        return quizRepository.getAllQuestionsWithAnswers();
    }

    // I know this should be in the score service but i cant be arsed to adapt everything
    @Override
    public int calculateScore(String[] userAnswers) {
        int score = 0;
        List<Question> questions = loadQuiz();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String userAnswer = userAnswers[i];

            for (Answer answer : question.getAnswers()) {
                if (answer.isCorrect() && answer.getAnswerText().equals(userAnswer)) {
                    score++;
                    break;
                }
            }
        }
        return score;
    }
}
