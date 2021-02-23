package net.sky.pieces;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public Position(String position) {
        this.x = position.charAt(0) - 'a';
        this.y = position.charAt(1) - 1;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
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
