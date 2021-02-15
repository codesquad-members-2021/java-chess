package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int PAWNSNUM = 8;
    private static final int COLUMN = 8;
    private List<Piece> whitePawns = new ArrayList<>(8);
    private List<Piece> blackPawns = new ArrayList<>(8);

    public List distinguish(Piece pawn) {
        if (pawn.getColor().equals(Piece.WHITE_COLOR)) {
            return whitePawns;
        }
        if (pawn.getColor().equals(Piece.BLACK_COLOR)) {
            return blackPawns;
        }
        return null;
    }

    public void add(Piece pawn) {
        List list = distinguish(pawn);
        list.add(pawn);
    }

    public int size(Piece pawn) {
        return distinguish(pawn).size();
    }

    public Piece findPawn(Piece pawn, int idx) {
        return (Piece) distinguish(pawn).get(idx);
    }

    public void initialize() {
        for (int i = 0; i < PAWNSNUM; i++) {
            Piece white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
            Piece black = new Piece(Piece.BLACK_COLOR, Piece.BLACK__REPRESENTATION);
            add(white);
            add(black);
        }
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        String empty = getEmptyResult();
        for (int i = 0; i < COLUMN; i++) {
            if (i == 1) {
                result.append(getBlackPawnResult());
            } else if (i == 6) {
                result.append(getWhitePawnResult());
            } else {
                result.append(empty);
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    public String getEmptyResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < PAWNSNUM; i++) {
            result.append(".");
        }
        return result.toString();
    }

    public String getWhitePawnResult() {
        return getPawnResult(whitePawns);
    }

    public String getBlackPawnResult() {
        return getPawnResult(blackPawns);
    }

    public String getPawnResult(List<Piece> pawns) {
        StringBuilder result = new StringBuilder();
        for (Piece pawn : pawns) {
            result.append(pawn.getRepresentation());
        }
        return result.toString();
    }
}
