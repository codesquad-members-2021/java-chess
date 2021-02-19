package net.woody.chess;

import net.woody.pieces.Color;
import net.woody.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private int size = 0;

    private final List<Rank> board = new ArrayList<Rank>(BOARD_LENGTH);

    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    public void add(Pawn pawn) {
        getPawnListByColor(pawn.getColor()).add(pawn);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findPawn(int idx, String colorName) {
        if (idx < 0 || size() <= idx) {
            throw new ArrayIndexOutOfBoundsException("Index number " + idx + " is out of range!");
        }
        Color color = Color.color(colorName);
        return getPawnListByColor(color).get(idx);
    }

    private List<Pawn> getPawnListByColor(Color color) {
        if (color.equals(Color.WHITE)) {
            return whitePawns;
        }
        return blackPawns;
    }

    public void initialize() {
        IntStream.rangeClosed(0, BOARD_LENGTH).forEach(i -> board.add(new Rank(i)));
        addInitialPawns();
    }

    private void addInitialPawns() {
        List<Pawn> whitePawns = getPawns(Pawn.WHITE_PAWN_RANK);
        List<Pawn> blackPawns = getPawns(Pawn.BLACK_PAWN_RANK);

        IntStream.range(0, BOARD_LENGTH).forEach(i -> {
            whitePawns.set(i, new Pawn());
            blackPawns.set(i, new Pawn(Color.BLACK.colorName()));
            size += 2;
        });
    }

    private List<Pawn> getPawns(int rank) {
        return board.get(rank).getPawns();
    }

    public String getWhitePawnsResult() {
        return getPawns(Pawn.WHITE_PAWN_RANK).toString();
    }

    public String getBlackPawnsResult() {
        return getPawns(Pawn.BLACK_PAWN_RANK).toString();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board) {
            sb.append(rank.toString());
        }
        return sb.toString();
    }
}
