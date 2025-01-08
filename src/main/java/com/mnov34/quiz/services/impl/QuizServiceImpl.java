package main.java.com.mnov34.quiz.services.impl;

import main.java.com.mnov34.quiz.models.Question;
import main.java.com.mnov34.quiz.repositories.QuizRepository;
import main.java.com.mnov34.quiz.repositories.impl.QuizRepositoryImpl;
import main.java.com.mnov34.quiz.services.QuizService;

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
}
