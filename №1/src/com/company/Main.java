package com.company;

public class Main {

    static class Point {
        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {

        Point vertexNumber1 = new Point(-5, 3);
        Point vertexNumber2 = new Point(4, -7);
        Point vertexNumber3 = new Point(3, 14);

        double perimeter, square;
        double sideNumber1, sideNumber2, sideNumber3;
        sideNumber1 = Math.sqrt(Math.pow(vertexNumber1.getX() - vertexNumber2.getX(), 2) + Math.pow(vertexNumber1.getY() - vertexNumber2.getY(), 2));
        sideNumber2 = Math.sqrt(Math.pow(vertexNumber2.getX() - vertexNumber3.getX(), 2) + Math.pow(vertexNumber2.getY() - vertexNumber3.getY(), 2));
        sideNumber3 = Math.sqrt(Math.pow(vertexNumber1.getX() - vertexNumber3.getX(), 2) + Math.pow(vertexNumber1.getY() - vertexNumber3.getY(), 2));

        perimeter = sideNumber1 + sideNumber2 + sideNumber3;
        square = Math.sqrt(perimeter / 2 * (perimeter / 2 - sideNumber1) * (perimeter / 2 - sideNumber2) * (perimeter / 2 - sideNumber3));

        System.out.print("Площадь равна: " + square);
    }
}
