package com.company;

public class Circle extends Figure {
    private int R;

    Circle(int x, int y, int R) {
        super.x1 = x;
        super.y1 = y;
        this.R = R;
    }

    public int getR() {
        return R;
    }

    @Override
    public String toString() {
        return String.format("C (%d, %d), %d", super.getX1(), super.getY1(), getR());
    }

    @Override
    public boolean isDotInFigure(int x, int y) {
        return Math.pow(x - super.getX1(), 2) + Math.pow(y - super.getY1(), 2) <= R * R;
    }
}
