package net.sky.pieces;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;
    private final int[] xMapping = {7, 6, 5, 4, 3, 2, 1, 0};

    public Position(String position) {
        int xIndex = Character.getNumericValue(position.charAt(1)) - 1;
        this.x = xMapping[xIndex];
        this.y = position.charAt(0) - 'a';
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
