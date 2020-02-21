package com.tamara.springboottraining1;

public enum Delimiters {

    PIPE("|"),
    COMMA(","),
    SEMICOLON(";");

    private final String ACCEPTED = String.valueOf(';');
    private String selected;

    Delimiters(String delimValue) {
        this.selected = delimValue;
    }
}
