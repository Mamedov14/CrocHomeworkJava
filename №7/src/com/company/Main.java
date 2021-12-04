package com.company;

public class Main {

    public static void main(String[] args) {

        String in = "g8,e7,e6";
        check(in);
        in = "g8,e7,e8";
        check(in);

    }

    public static void check(String in) {
        String[] inArr = in.split(",");
        for (int i = 0; i < inArr.length - 1; i++) {
            try {
                checkHorseStep(ChessPosition.parse(inArr[i]), ChessPosition.parse(inArr[i + 1]));
            } catch (IllegalMoveException e) {
                // e.printStackTrace();
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("OK");
    }


    private static void checkHorseStep(ChessPosition startPosition, ChessPosition endPosition) throws IllegalMoveException {
        if (Math.abs(startPosition.column - endPosition.column) + Math.abs(startPosition.row - endPosition.row) != 3) {
            throw new IllegalMoveException(startPosition, endPosition);
        }
        System.out.println(startPosition + " - > " + endPosition);
    }
}
