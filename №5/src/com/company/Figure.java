package com.company;

public abstract class Figure {
    protected int x1, y1;

    public abstract boolean isDotInFigure(int x, int y);

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
