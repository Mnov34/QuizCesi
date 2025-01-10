package com.mnov34.quiz.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maël NOUVEL <br>
 * 01/2025
 **/
public class Question {
    private int id;
    private String name;
    private List<Answer> answers = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
