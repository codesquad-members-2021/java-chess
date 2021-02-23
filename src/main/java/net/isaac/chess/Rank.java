package net.isaac.chess;

import net.isaac.pieces.Piece;

public class Rank {
    private static final int MAX_SIZE = 8;
    private Piece[] pieces = new Piece[MAX_SIZE];

    public Rank() {
        for (int index = 0; index < MAX_SIZE; index++) {
            pieces[index] = Piece.createPiece(Piece.Color.NOCOLOR, Piece.Type.BLANK);
        }
    }

    public Piece getPiece(char alphabet) {
        int index = getIndex(alphabet);
        if (!isValid(index)) {
            System.err.println(String.format("Rank.getPiece: %c는 유효한 자리가 아닙니다.", alphabet));
            return null;
        }

        return pieces[index];
    }

    public void setPiece(Piece piece, char alphabet) {
        int index = getIndex(alphabet);
        if (!isValid(index)) {
            System.err.println(String.format("Rank.setPiece: %c는 유효한 자리가 아닙니다.", alphabet));
            return;
        }

        pieces[index] = piece;
    }

    private int getIndex(char alphabet) {
        return alphabet - 'a';
    }

    private boolean isValid(int index) {
        return index >= 0 && index < MAX_SIZE;
    }
}
