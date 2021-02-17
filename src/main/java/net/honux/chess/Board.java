package net.honux.chess;

import net.honux.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private static final int BOARD_LENGTH = 8;
    private static final int BLACK_PAWN_ROW = 1;
    private static final int WHITE_PAWN_ROW = 6;

    private final Pawn[][] board = new Pawn[BOARD_LENGTH][BOARD_LENGTH];

    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    public void add(Pawn pawn) {
        getPawnListByColor(pawn.getColor()).add(pawn);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findPawn(int idx, String color) {
        if (idx < 0 || size() <= idx) {
            throw new ArrayIndexOutOfBoundsException("Index number " + idx + " is out of range!");
        }
        return getPawnListByColor(color).get(idx);
    }

    private List<Pawn> getPawnListByColor(String color) {
        if (color.equals(Pawn.WHITE_COLOR)) {
            return whitePawns;
        } else if (color.equals(Pawn.BLACK_COLOR)) {
            return blackPawns;
        }
        throw new IllegalArgumentException("Cannot get the pawn list of this color, " + color);
    }

    public void initialize() {
        IntStream.range(0, BOARD_LENGTH).forEach(i -> {
            whitePawns.add(i, new Pawn());
            board[WHITE_PAWN_ROW][i] = whitePawns.get(i);
            blackPawns.add(i, new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
            board[BLACK_PAWN_ROW][i] = blackPawns.get(i);
        });
    }

    public String getPawnsResult(String color, char representation) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : getPawnListByColor(color)) {
            char represent = (pawn == null) ? '.' : representation;
            sb.append(represent);
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < Board.BOARD_LENGTH; row++) {
            for (int col = 0; col < Board.BOARD_LENGTH; col++) {
                Pawn pawn = board[row][col];
                if (pawn == null) {
                    sb.append('.');
                } else {
                    sb.append(pawn.getRepresentation());
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
