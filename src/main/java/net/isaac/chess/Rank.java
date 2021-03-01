package net.isaac.chess;

import net.isaac.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public class Rank {
    public static final char MIN_FILE = 'a';
    public static final char MAX_FILE = 'h';
    private final Map<Character, Piece> pieces = new HashMap<>();

    public Rank() {
        for (char file = MIN_FILE; file <= MAX_FILE; file++) {
            setPiece(Piece.createPiece(Piece.Color.NOCOLOR, Piece.Type.BLANK), file);
        }
    }

    public Piece getPiece(char file) {
        if (!isValid(file)) {
            System.err.println(String.format("Rank.getPiece: %c는 유효한 자리가 아닙니다.", file));
            return null;
        }

        return pieces.get(file);
    }

    public void setPiece(Piece piece, char file) {
        if (!isValid(file)) {
            System.err.println(String.format("Rank.setPiece: %c는 유효한 자리가 아닙니다.", file));
            return;
        }

        pieces.put(file, piece);
    }

    private boolean isValid(int index) {
        return index >= MIN_FILE && index <= MAX_FILE;
    }
}
