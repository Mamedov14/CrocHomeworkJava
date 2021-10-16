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
}
