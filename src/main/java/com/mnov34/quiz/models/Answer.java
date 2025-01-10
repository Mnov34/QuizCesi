package com.mnov34.quiz.models;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class Answer {
    private Integer id;
    private String name;
    private Boolean correct;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return name;
    }

    public void setAnswerText(String answerText) {
        this.name = answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

}
