package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Pawn;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>(8);
    private List<Pawn> blackPawns = new ArrayList<>(8);

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

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn aPawn : pawns) {
            sb.append(aPawn.getRepresentation());
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getBlankLine() {
        return "........";
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
        for (int i = 0; i < 8; i++) {
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
}
