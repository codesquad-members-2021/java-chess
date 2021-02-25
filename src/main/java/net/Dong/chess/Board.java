package net.Dong.chess;

import static net.Dong.chess.Pawn.Color;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private List<Pawn> whitePawn = new ArrayList<>();
    private List<Pawn> blackPawn = new ArrayList<>();


    public static final String EMPTY_LINE = "........";
    public static final String NEW_LINE = System.getProperty("line.separator");


    public void addWhitePawn(Pawn pawn) {
        whitePawn.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawn.add(pawn);
    }

    public int size() {
        return whitePawn.size() + blackPawn.size();
    }

    private int whitePawnSize() {
        return whitePawn.size();
    }

    private int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawn.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawn.get(index);
    }

    public void initialize() {
        addWhitePawn(Pawn.InitialNumOfPawn);
        addBlackPawn(Pawn.InitialNumOfPawn);
    }

    private void addWhitePawn(int numOfPawn) {
        for (int i = 0; i < numOfPawn; i++) {
            whitePawn.add(new Pawn(Color.WHITE));
        }
    }

    private void addBlackPawn(int numOfPawn) {
        for (int i = 0; i < numOfPawn; i++) {
            blackPawn.add(new Pawn(Color.BLACK));
        }
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawn);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawn);
    }

    private String getPawnsResult(List<Pawn> whatPawn) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : whatPawn) {
            sb.append(pawn.getSymbol());
        }
        return sb.toString();
    }

    public String LayoutToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EMPTY_LINE).append(NEW_LINE);
        sb.append(getBlackPawnsResult()).append(NEW_LINE);
        sb.append(EMPTY_LINE).append(NEW_LINE);
        sb.append(EMPTY_LINE).append(NEW_LINE);
        sb.append(EMPTY_LINE).append(NEW_LINE);
        sb.append(EMPTY_LINE).append(NEW_LINE);
        sb.append(getWhitePawnsResult()).append(NEW_LINE);
        sb.append(EMPTY_LINE).append(NEW_LINE);
        return sb.toString();
    }
}
