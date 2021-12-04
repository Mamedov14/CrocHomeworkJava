package com.company;

public class ChessPosition {

    private static final char START_COLUMN = 'a';
    public int row;
    public int column;

    private ChessPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static ChessPosition parse(String position) {

        if (position == null || position.length() != 2) {
            throw new IllegalPositionException();
        }

        int column = position.charAt(0) - START_COLUMN;
        int row = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;

        return new ChessPosition(row, column);
    }

    @Override
    public String toString() {
        return "" + (char) (START_COLUMN + column) + (row + 1);
    }
}
