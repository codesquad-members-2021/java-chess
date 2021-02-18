package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;


public class Board {
    private static final int MAX_SIZE = 8;
    private static final int SECOND_ROW = 1;
    private static final int SEVENTH_ROW = 6;
    private final List<Pawn> pawns = new ArrayList<>();
    private final StringBuilder rowOfBlackPawns = new StringBuilder();
    private final StringBuilder rowOfWhitePawns = new StringBuilder();
    private final String[] cellsOfBoard = {
            "********",
            "********",
            "********",
            "********",
            "********",
            "********",
            "********",
            "********"
    };

    public Board() {
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public void initialize() {
        for (Color color : Color.values()) {
            initPawns(color);
            initCellsOfBoard(color);
        }
    }

    private void initPawns(Color color) {
        for (int i = 0; i < MAX_SIZE; i++) {
            Pawn pawn = new Pawn(color);
            pawns.add(pawn);
        }
    }

    private void initCellsOfBoard(Color color) {
        if (color == Color.WHITE) {
            cellsOfBoard[SECOND_ROW] = getRowOfPawns(color);
        } else {
            cellsOfBoard[SEVENTH_ROW] = getRowOfPawns(color);
        }
    }

    public String getRowOfPawns(Color color) {
        return pawns.stream()
                .filter(pawn -> pawn.getColor() == color)
                .map(Pawn::getRepresentation)
                .map(Object::toString)
                .collect(joining());
    }

    public String[] getCellsOfBoard() {
        return cellsOfBoard;
    }
}
