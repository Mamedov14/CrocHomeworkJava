package com.company;

public class Rectangle extends Figure {
    private int x2, y2;

    Rectangle(int x1, int y1, int x2, int y2) {
        super.x1 = x1;
        super.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public String toString() {
        return String.format("R (%d, %d), (%d, %d)", super.getX1(), super.getY1(), getX2(), getY2());
    }

    @Override
    public boolean isDotInFigure(int x, int y) {
        return (x >= getX2() && y >= getY2())
                && (x <= super.getX1() && y <= super.getY1());
    }
}
