package net.coco.valid;

import net.coco.pieces.Piece;
import net.coco.pieces.PieceType;

public class PieceValid {
    public static void checkColorType(String color) {
        if (!(color.equals(Piece.WHITE) || color.equals(Piece.BLACK)))
            throw new IllegalArgumentException("white나 black을 넣어주세요");
    }

    public static boolean isPawn(Piece piece) {
        char getRepresentation = Character.toUpperCase(piece.getRepresentation());

        if (getRepresentation != PieceType.KING.getRepresentation(Piece.BLACK)) {
            System.out.println("pawn 말고 다른 piece는 넣지 말아주세요.");
            return false;
        }
        return true;
    }

    public static boolean isOtherPiece(Piece piece) {
        char getRepresentation = Character.toUpperCase(piece.getRepresentation());

        if (getRepresentation == PieceType.PAWN.getRepresentation(Piece.BLACK)) {
            System.out.println("pawn은 넣지 말아주세요.");
            return false;
        }
        return true;
    }
}
