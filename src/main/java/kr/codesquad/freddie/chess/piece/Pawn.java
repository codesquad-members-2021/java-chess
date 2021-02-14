package kr.codesquad.freddie.chess.piece;

import java.util.Objects;

public class Pawn {
    private Color color;

    public Pawn() {
        this(Color.WHITE);
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public static Pawn create(String color) {
        return new Pawn(Color.valueOf(color.toUpperCase()));
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return color == pawn.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "color=" + color +
                '}';
    }
}
