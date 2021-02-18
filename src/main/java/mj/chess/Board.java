package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;


public class Board {
    private static final int MAX_SIZE = 8;
    private static final int SECOND_ROW = 1;
    private static final int SEVENTH_ROW = 6;
    private final List<Piece> pieces = new ArrayList<>();
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

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPawn(int index) {
        return pieces.get(index);
    }

    public void initialize() {
        for (Color color : Color.values()) {
            initPawns(color);
            initCellsOfBoard(color);
        }
    }

    private void initPawns(Color color) {
        for (int i = 0; i < MAX_SIZE; i++) {
            Piece piece = new Piece(color);
            pieces.add(piece);
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
        return pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .map(Piece::getRepresentation)
                .map(Object::toString)
                .collect(joining());
    }

    public String[] getCellsOfBoard() {
        return cellsOfBoard;
    }
}
