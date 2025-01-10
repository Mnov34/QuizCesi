package com.mnov34.quiz.repositories.impl;

import com.mnov34.quiz.config.Database;
import com.mnov34.quiz.models.Answer;
import com.mnov34.quiz.models.Question;
import com.mnov34.quiz.repositories.QuizRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class QuizRepositoryImpl implements QuizRepository {


    @Override
    public List<Question> getAllQuestionsWithAnswers() {
        String sql =
                "SELECT q.id AS question_id, q.question_text, " +
                        "       a.id AS answer_id, a.answer_text, a.correct " +
                        "  FROM question q " +
                        "  JOIN answer a ON q.id = a.question_id " +
                        " ORDER BY q.id, a.id";

        Map<Integer, Question> questionMap = new HashMap<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int questionId = resultSet.getInt("question_id");
                String questionText = resultSet.getString("question_text");
                int answerId = resultSet.getInt("answer_id");
                String answerText = resultSet.getString("answer_text");
                boolean correct = resultSet.getBoolean("correct");

                // Check if we have this Question already
                Question question = questionMap.get(questionId);
                if (question == null) {
                    question = new Question();
                    question.setId(questionId);
                    question.setName(questionText);
                    question.setAnswers(new ArrayList<>());
                    questionMap.put(questionId, question);
                }

                // Create the Answer
                Answer answer = new Answer();
                answer.setId(answerId);
                answer.setAnswerText(answerText);
                answer.setCorrect(correct);

                // Attach answer to question
                question.getAnswers().add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(questionMap.values());

    }
}
