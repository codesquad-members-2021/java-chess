package chess;

import chess.pieces.Piece;
import chess.pieces.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int PAWNSNUM = 8;
    private static final int COLUMN = 8;
    private List<Piece> whitePawns = new ArrayList<>(8);
    private List<Piece> blackPawns = new ArrayList<>(8);


    public List<Piece> distinguish(Piece pawn) {
        if (pawn.getColor() == Color.WHITE) {
            return whitePawns;
        }
        return blackPawns;
    }

    public void add(Piece pawn) {
        List list = distinguish(pawn);
        list.add(pawn);
    }

    public int size(Piece pawn) {
        return distinguish(pawn).size();
    }


    public Piece findPawn(Piece pawn, int idx) {
        return distinguish(pawn).get(idx);
    }

    public void initialize() {
        for (int i = 0; i < PAWNSNUM; i++) {
            Piece white = new Piece(Color.WHITE);
            Piece black = new Piece(Color.BLACK);
            add(white);
            add(black);
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        String empty = getEmptyResult();
        for (int i = 0; i < COLUMN; i++) {
            if (i == 1) {
                result.append(getBlackPawnResult());
            }
            if (i == 6) {
                result.append(getWhitePawnResult());
            }
            if (i != 1 && i != 6) {
                result.append(empty);
            }
            result.append("\n");
        }
        return result.toString();
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

    private String getPawnResult(List<Piece> pawns) {
        StringBuilder result = new StringBuilder();
        for (Piece pawn : pawns) {
            result.append(pawn.getColor().getRepresentation());
        }
        return result.toString();
    }
}
