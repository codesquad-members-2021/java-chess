package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Pawn;

public class Board {
    private static int PAWN_NUM = 8;
    private List<Pawn> whitePawns = new ArrayList<>(PAWN_NUM);
    private List<Pawn> blackPawns = new ArrayList<>(PAWN_NUM);

    boolean addWhitePawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE)) {
            whitePawns.add(pawn);
            return true;
        }
        return false;
    }

    boolean addBlackPawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.BLACK)) {
            blackPawns.add(pawn);
            return true;
        }
        return false;
    }

    public int getWhitePawnsSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn aPawn : pawns) {
            sb.append(aPawn.getRepresentation());
        }
        return sb.toString();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    void initialize() {
        Pawn whitePawn = new Pawn();
        Pawn blackPawn = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        for (int i = 0; i < PAWN_NUM; i++) {
            whitePawns.add(whitePawn);
            blackPawns.add(blackPawn);
        }
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlackPawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getWhitePawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        System.out.println(sb.toString());
    }

    private String getBlankLine() {
        return "........";
    }
}
