package net.woody.chess;

import net.woody.pieces.Color;
import net.woody.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final Pawn[][] board = new Pawn[BOARD_LENGTH][BOARD_LENGTH];

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
        IntStream.range(0, BOARD_LENGTH).forEach(i -> {
            whitePawns.add(i, new Pawn());
            board[Pawn.WHITE_PAWN_ROW][i] = whitePawns.get(i);
            blackPawns.add(i, new Pawn(Color.BLACK.colorName()));
            board[Pawn.BLACK_PAWN_ROW][i] = blackPawns.get(i);
        });
    }

    private String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : getPawnListByColor(color)) {
            char represent = (pawn == null) ? '.' : color.representation(Pawn.PAWN_REPRESENTATION);
            sb.append(represent);
        }
        return sb.toString();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(Color.WHITE);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(Color.BLACK);
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
