package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int PAWNSNUM = 8;
    private static final int COLUMN = 8;
    private List<Pawn> whitePawns = new ArrayList<>(8);
    private List<Pawn> blackPawns = new ArrayList<>(8);
    
    public List<Pawn> distinguish(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            return whitePawns;
        }
        return blackPawns;
    }

    public void add(Pawn pawn) {
        List list = distinguish(pawn);
        list.add(pawn);
    }

    public int size(Pawn pawn) {
        return distinguish(pawn).size();
    }

    public Pawn findPawn(Pawn pawn, int idx) {
        return distinguish(pawn).get(idx);
    }

    public void initialize() {
        for (int i = 0; i < PAWNSNUM; i++) {
            Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
            Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK__REPRESENTATION);
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

    private String getPawnResult(List<Pawn> pawns) {
        StringBuilder result = new StringBuilder();
        for (Pawn pawn : pawns) {
            result.append(pawn.getRepresentation());
        }
        return result.toString();
    }
}
