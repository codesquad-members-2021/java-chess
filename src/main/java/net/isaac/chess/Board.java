package net.isaac.chess;

import net.isaac.pieces.Piece;
import net.isaac.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int MAX_SIZE = 8;
    private static final int MAX_IDX = MAX_SIZE - 1;

    private Piece[][] pieces = new Piece[MAX_SIZE][MAX_SIZE];
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void initialize() {
        int pawnsRow = 1;
        initializePawns(Piece.Color.BLACK, pawnsRow);
        initializePawns(Piece.Color.WHITE, MAX_IDX - pawnsRow);

        int specialRow = 0;
        initializeSpecialPieces(Piece.Color.BLACK, specialRow);
        initializeSpecialPieces(Piece.Color.WHITE, MAX_IDX - specialRow);
    }

    private void initializeSpecialPieces(Piece.Color color, int row) {
        int rookColumn = 0;
        add(Piece.createRook(color), row, rookColumn);
        add(Piece.createRook(color), row, MAX_IDX - rookColumn);

        int knightColumn = 1;
        add(Piece.createKnight(color), row, knightColumn);
        add(Piece.createKnight(color), row, MAX_IDX - knightColumn);

        int bishopColumn = 2;
        add(Piece.createBishop(color), row, bishopColumn);
        add(Piece.createBishop(color), row, MAX_IDX - bishopColumn);

        int QueenColumn = 3;
        add(Piece.createQueen(color), row, QueenColumn);

        int KingColumn = 4;
        add(Piece.createKing(color), row, KingColumn);
    }

    private void initializePawns(Piece.Color color, int row) {
        for (int column = 0; column < MAX_SIZE; column++) {
            add(Piece.createPawn(color), row, column);
        }
    }

    public void print() {
        System.out.println(getRepresentation());
    }

    public String getRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (pieces[i][j] == null)
                    builder.append('.');
                else
                    builder.append(pieces[i][j].getRepresentation());
            }
            builder.append(StringUtils.NEWLINE);
        }
        return builder.toString();
    }

    public String getWhitePiecesResult() {
        return this.whitePieces.stream().
                map(x -> String.valueOf(x.getRepresentation())).
                reduce("", (a, b) -> a + b);
    }

    public String getBlackPiecesResult() {
        return this.blackPieces.stream().
                map(x -> String.valueOf(x.getRepresentation())).
                reduce("", (a, b) -> a + b);
    }

    public void add(Piece piece, int rowIdx, int colIdx) {
        if (!isValid(rowIdx) || !isValid(colIdx)) {
            System.err.println("Board.add: 위치가 체스보드 범위를 벗어났습니다.");
            return;
        }

        pieces[rowIdx][colIdx] = piece;

        switch (piece.getColor()) {
            case BLACK:
                blackPieces.add(piece);
                break;
            case WHITE:
                whitePieces.add(piece);
                break;
        }
    }

    public Piece findPiece(int rowIdx, int colIdx) {
        if (!isValid(rowIdx) || !isValid(colIdx))
            return null;

        return pieces[rowIdx][colIdx];
    }

    private boolean isValid(int location) {
        return location >= 0 && MAX_SIZE > location;
    }

    public int size() {
        return MAX_SIZE * MAX_SIZE;
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }
}
