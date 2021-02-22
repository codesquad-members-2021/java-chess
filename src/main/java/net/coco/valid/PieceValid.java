package net.coco.valid;

import net.coco.pieces.Piece;
import net.coco.pieces.PieceType;

public class PieceValid {
    public static void checkColorType(String color) {
        if (!(color.equals(Piece.WHITE) || color.equals(Piece.BLACK) || color.equals(Piece.NO_COLOR)))
            throw new IllegalArgumentException("white나 black, 또는 NO_COLOR를 넣어주세요");
    }

    public static boolean isPawn(Piece piece) {
        char getRepresentation = Character.toUpperCase(piece.getRepresentation());

        if (getRepresentation != PieceType.PAWN.getRepresentation(Piece.BLACK)) {
            return false;
        }
        return true;
    }

    public static void piecePointValid(int row, int column) {
        if (row >= 8 || row < 0) {
            throw new IllegalArgumentException("올바른 point가 아닙니다.");
        }
        if (column >= 8 || column < 0) {
            throw new IllegalArgumentException("올바른 point가 아닙니다.");
        }
    }

    public static boolean isOtherPiece(Piece piece) {
        char getRepresentation = Character.toUpperCase(piece.getRepresentation());

        if (getRepresentation == PieceType.PAWN.getRepresentation(Piece.BLACK)) {
            return false;
        }
        return true;
    }
}
