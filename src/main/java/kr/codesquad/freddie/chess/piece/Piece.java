package kr.codesquad.freddie.chess.piece;

import java.util.Objects;

public class Piece {
    private Color color;
    private Kind kind;

    public Piece(Color color, Kind kind) {
        this.color = color;
        this.kind = kind;
    }

    public Color getColor() {
        return color;
    }

    public Kind getKind() {
        return kind;
    }

    public String getRepresentation() {
        return color.getRepresentationBy(kind.representation);
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
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
