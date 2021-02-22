package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Type;

public class Piece {

    private final Color color;
    private final char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN.getRepresentation(Color.WHITE));
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN.getRepresentation(Color.BLACK));
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT.getRepresentation(Color.WHITE));
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT.getRepresentation(Color.BLACK));
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP.getRepresentation(Color.WHITE));
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP.getRepresentation(Color.BLACK));
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK.getRepresentation(Color.WHITE));
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK.getRepresentation(Color.BLACK));
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN.getRepresentation(Color.WHITE));
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN.getRepresentation(Color.BLACK));
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING.getRepresentation(Color.WHITE));
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING.getRepresentation(Color.BLACK));
    }

    public static Piece createBlank() { return new Piece(Color.NOCOLOR, Type.NO_PIECE.getRepresentation(Color.NOCOLOR));}

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.representation;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }
}
