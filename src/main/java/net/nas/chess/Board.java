package net.nas.chess;

import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.Pawn;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {
    private ArrayList<Pawn> pieceList;
    private ChessCell[][] chessCells;

    public Board() {
        pieceList = new ArrayList<>();
        chessCells = new ChessCell[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                chessCells[i][j] = new ChessCell();
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            chessCells[1][i].occupy(new Pawn());
            chessCells[6][i].occupy(new Pawn(ColorOfChessPiece.BLACK));
        }
    }

    public void print() {
        System.out.println(getResultOfAllRows());
    }

    public String getResultOfAllRows() {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append(getResultOfRow(i));
            if (i != 0)
                sb.append("\n");
        }
        return sb.toString();
    }

    private String getResultOfRow(int rowIdx) {
        return Arrays.stream(chessCells[rowIdx])
                .map(cell -> String.valueOf(cell.getRepresentation()))
                .collect(Collectors.joining());
    }

    public String getWhitePawnsResult() {
        return getResultOfRow(1);
    }

    public String getBlackPawnsResult() {
        return getResultOfRow(6);
    }

    public Pawn findPawn(int idx) {
        if (idx < 0 || pieceList.size() <= idx)
            throw new InvalidParameterException("index exceeded the bounds of the pieceList");
        return pieceList.get(idx);
    }

    public void add(Pawn piece) {
        if (piece == null)
            throw new InvalidParameterException("Null value cannot be added in board");
        pieceList.add(piece);
    }

    public int size() {
        return pieceList.size();
    }
}
