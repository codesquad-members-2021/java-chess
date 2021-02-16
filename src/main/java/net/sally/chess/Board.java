package net.sally.chess;

import net.sally.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public static int BOARD_SIZE = 8;

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(new Pawn());
            addBlackPawn(new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder pawnsResult = new StringBuilder();
        for (Pawn p : pawns) {
            pawnsResult.append(p.getRepresentation());
        }
        return pawnsResult.toString();
    }

    public void addWhitePawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE)) {
            whitePawns.add(pawn);
        }
    }

    public void addBlackPawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.BLACK)) {
            blackPawns.add(pawn);
        }
    }

    public int getWhitePawnSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public Pawn findWhitePawn(int i) {
        return whitePawns.get(i);
    }

    public Pawn findBlackPawn(int i) {
        return blackPawns.get(i);
    }

    public void print() {
        StringBuilder printer = new StringBuilder();
        printer.append("........\n");
        printer.append("........\n");
        printer.append(getBlackPawnsResult());
        printer.append(System.lineSeparator());
        printer.append("........\n");
        printer.append("........\n");
        printer.append("........\n");
        printer.append("........\n");
        printer.append("........\n");
        printer.append(getWhitePawnsResult());
        printer.append(System.lineSeparator());
        printer.append("........");

        System.out.println(printer.toString());
    }
}
