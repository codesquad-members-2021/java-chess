package net.sky.pieces;


import java.util.List;
import java.util.Objects;

public class Piece {

    private final Color color;
    private final PieceType pieceType;
    private final char representation;

    public Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.representation = classifyRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isWhite(Piece piece) {
        return piece.getColor() == Color.WHITE;
    }

    public boolean isBlack(Piece piece) {
        return piece.getColor() == Color.BLACK;
    }

    public double getDefaultPoint() {
        return pieceType.getPoint();
    }

    public double getPoint(List<Piece> fileList) {
        double defaultPoint = pieceType.getPoint();

        if (pieceType != PieceType.PAWN) {
            return defaultPoint;
        }

        int count = 0;
        for (Piece piece : fileList) {
            if (piece.getPieceType() == PieceType.PAWN) {
                count += 1;
            }
        }

        return count > 1 ? defaultPoint / 2 : defaultPoint;
    }

    private char classifyRepresentation() {
        char initRepresentation = pieceType.getRepresentation();
        return color == Color.BLACK ? Character.toUpperCase(initRepresentation)
            : initRepresentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return representation == piece.representation && color == piece.color
            && pieceType == piece.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, pieceType, representation);
    }

    @Override
    public String toString() {
        return getRepresentation() + "";
    }
}
