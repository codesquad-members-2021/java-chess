package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;
import mj.chess.pieces.Type;
import mj.chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtils.appendNewLine;

public class Board {
    private static final int NUM_OF_ALL_PIECES = 32;
    private static final int SECOND_ROW = 1;
    private static final int SEVENTH_ROW = 6;
    private static final int SIZE_OF_ROW = 8;
    private final List<Piece> pieces = new ArrayList<>();
    private final StringBuilder rowOfBlackPawns = new StringBuilder();
    private final StringBuilder rowOfWhitePawns = new StringBuilder();
    private final StringBuilder[] cellsOfBoard = new StringBuilder[SIZE_OF_ROW];

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
        }
        initCellsOfBoard();
    }

    private void initPawns(Color color) {
        for (int i = 0; i < SIZE_OF_ROW; i++) {
            Piece pawn = (color == Color.WHITE) ? Piece.createWhitePawn() : Piece.createBlackPawn();
            pieces.add(pawn);
        }
    }

    // TODO: 스트림으로 바꿔보자
    private void initCellsOfBoard() {
        StringBuilder blankRank = appendNewLine("........");

        for(int nthRow = 0; nthRow < SIZE_OF_ROW; nthRow++){
                cellsOfBoard[nthRow] = blankRank;
        }

        cellsOfBoard[SECOND_ROW] = StringUtils.appendNewLine(getRowOfPawns(Color.BLACK));
        cellsOfBoard[SEVENTH_ROW] = StringUtils.appendNewLine(getRowOfPawns(Color.WHITE));
    }

    public StringBuilder[] getCellsOfBoard() {
        return cellsOfBoard;
    }

    public int countPieces() {
        return pieces.size();
    }
    public int countPawns() {
        return (int) pieces.stream()
                .filter(pawn -> pawn.getType() == Type.PAWN)
                .count();
    }

    //TODO: 스트림으로 바꿔보자
    public String showBoard() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < SIZE_OF_ROW; i++) {
            result.append(cellsOfBoard[i]);
        }

        return result.toString();
    }

    public String getRowOfPawns(Color color) {
        return pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .map(Piece::getRepresentation)
                .map(Object::toString)
                .collect(joining());
    }
}
