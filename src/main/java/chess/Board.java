package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();
    private static final int BOARD_SIZE = 8;
    private static final String NEW_LINE = System.lineSeparator();
    private static final String EMPTY = "........" + NEW_LINE;


    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addBlackPawn(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    private boolean checkPawnColor(Pawn pawn, String color){
        return pawn.getColor().equals(color);
    }


    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder pawnsResult = new StringBuilder();
        for (Pawn pawn : pawns)
            pawnsResult.append(pawn.getRepresentation());
        return pawnsResult.toString();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public int size() {
        return blackPawns.size() + whitePawns.size();
    }

    public String printBoard() {
        StringBuilder result = new StringBuilder();
        result.append(EMPTY)
                .append(getWhitePawnsResult())
                .append(NEW_LINE)
                .append(EMPTY)
                .append(EMPTY)
                .append(EMPTY)
                .append(EMPTY)
                .append(getBlackPawnsResult())
                .append(NEW_LINE)
                .append(EMPTY);

        return result.toString();
    }
}
