package chess;

import pieces.Pawn;
import pieces.Pawn.Color;

import java.util.*;

public class Board {
    private final List<Pawn> blackPawns;
    private final List<Pawn> whitePawns;
    private final String EMPTY_LINE = "........";
    private final int BOARD_SIZE = 8;

    public Board() {
        blackPawns = new ArrayList<>();
        whitePawns = new ArrayList<>();
    }

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    private String getWhitePawnsToPrint() {
        return getPawnsToPrint(whitePawns);
    }

    private String getBlackPawnsToPrint() {
        return getPawnsToPrint(blackPawns);
    }

    private String getPawnsToPrint(List<Pawn> pawns) {
        StringBuilder pawnsToPrint = new StringBuilder();
        for (Pawn pawn : pawns) {
            pawnsToPrint.append(pawn.getColor().getRepresentation());
        }
        return pawnsToPrint.toString();
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i == 1) {
                result.append(getBlackPawnsToPrint());
            } else if (i == 6) {
                result.append(getWhitePawnsToPrint());
            } else {
                result.append(EMPTY_LINE);
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return whitePawns.get(index);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }
}
