package com.company;

public class Annotation {
    private Figure figure;
    private String note;

    public Annotation(Figure figure, String note) {
        this.figure = figure;
        this.note = note;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getFigure().toString(), getNote());
    }
}
