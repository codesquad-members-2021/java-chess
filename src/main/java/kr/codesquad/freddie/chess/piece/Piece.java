package kr.codesquad.freddie.chess.piece;

import java.util.Objects;

public class Piece {
    private Color color;
    private Kind kind;

    public Piece(Color color, Kind kind) {
        this.color = color;
        this.kind = kind;
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Kind.PAWN);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Kind.PAWN);
    }

    public static Piece create(String color, String kind) {
        return new Piece(Color.valueOf(color.toUpperCase()), Kind.valueOf(kind.toUpperCase()));
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
        Piece piece = (Piece) o;
        return color == piece.color && kind == piece.kind;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, kind);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", kind=" + kind +
                '}';
    }
}
