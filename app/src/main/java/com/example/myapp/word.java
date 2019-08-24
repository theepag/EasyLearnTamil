package com.example.myapp;

import android.graphics.Bitmap;

import java.sql.Blob;

public class word {
    private String name;
    private String type;

    private String question;
    private String hint;

    public word() {

    }

    public word(String name, String type, String question, String hint) {
        this.name = name;
        this.type = type;

        this.question = question;
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}