package net.coco.valid;

import net.coco.pieces.Piece;

public class PieceValid {
    public static void checkColorType(String color) {
        if (!(color.equals(Piece.WHITE) || color.equals(Piece.BLACK)))
            throw new IllegalArgumentException("white나 black을 넣어주세요");
    }
}
