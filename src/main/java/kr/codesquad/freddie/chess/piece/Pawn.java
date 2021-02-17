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

    public static Pawn createBlackPawn() {
        return new Pawn(Color.BLACK);
    }

    public static Pawn createWhitePawn() {
        return new Pawn(Color.WHITE);
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return color.getRepresentationBy("p");
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
