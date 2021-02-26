package net.coco.pieces;

public class Point {
    private final int column;
    private final int row;

    public Point(String point) {
        this.column = point.charAt(0) - 'a';
        this.row = Character.getNumericValue(point.charAt(1)) - 1;
        pointValid(row, column);
    }

    private void pointValid(int row, int column) {
        if (row >= 8 || row < 0 || column >= 8 || column < 0) {
            throw new IllegalArgumentException("올바른 point가 아닙니다.");
        }
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
