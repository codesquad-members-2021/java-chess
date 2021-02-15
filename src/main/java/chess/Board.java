package chess;

import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    public Board() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        initialize();
    }

    public void add(Piece piece) {
        if (piece.getColor().equals(Piece.WHITE_COLOR)) {
            whitePieces.add(piece);
        } else {
            blackPieces.add(piece);
        }
    }

    public void addBlack(Piece piece) {
        blackPieces.add(piece);
    }

    public void addWhite(Piece piece) {
        whitePieces.add(piece);
    }

    public int size() {
        return whitePieces.size() + blackPieces.size();
    }

    public Piece findWhite(int index) {
        return whitePieces.get(index);
    }

    public Piece findBlack(int index) {
        return blackPieces.get(index);
    }

    void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            add(new Pawn(Piece.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            add(new Pawn(Piece.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    String getWhitePawnsResult() {
        return "";
    }

    String getBlackPawnsResult() {
        return "";
    }
}
