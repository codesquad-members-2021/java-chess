package net.isaac.chess;

import net.isaac.pieces.Piece;
import net.isaac.utils.StringUtils;

public class Board {
    private static final int MAX_SIZE = 8;
    private static final int MAX_IDX = MAX_SIZE - 1;

    private Piece[][] pieces = new Piece[MAX_SIZE][MAX_SIZE];

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
        add(Piece.createPiece(color, Piece.Type.ROOK), row, rookColumn);
        add(Piece.createPiece(color, Piece.Type.ROOK), row, MAX_IDX - rookColumn);

        int knightColumn = 1;
        add(Piece.createPiece(color, Piece.Type.KNIGHT), row, knightColumn);
        add(Piece.createPiece(color, Piece.Type.KNIGHT), row, MAX_IDX - knightColumn);

        int bishopColumn = 2;
        add(Piece.createPiece(color, Piece.Type.BISHOP), row, bishopColumn);
        add(Piece.createPiece(color, Piece.Type.BISHOP), row, MAX_IDX - bishopColumn);

        int QueenColumn = 3;
        add(Piece.createPiece(color, Piece.Type.QUEEN), row, QueenColumn);

        int KingColumn = 4;
        add(Piece.createPiece(color, Piece.Type.KING), row, KingColumn);
    }

    private void initializePawns(Piece.Color color, int row) {
        for (int column = 0; column < MAX_SIZE; column++) {
            add(Piece.createPiece(color, Piece.Type.PAWN), row, column);
        }
    }

    public String getRepresentation() {
        String ret = "";
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (pieces[i][j] == null) {
                    ret += '.';
                } else {
                    ret += pieces[i][j].getRepresentation();
                }
            }
            ret = StringUtils.appendNewLine(ret);
        }
        return ret;
    }

    public void add(Piece piece, int rowIdx, int colIdx) {
        if (!isValid(rowIdx) || !isValid(colIdx)) {
            System.err.println("Board.add: 위치가 체스보드 범위를 벗어났습니다.");
            return;
        }

        pieces[rowIdx][colIdx] = piece;
    }

    public Piece findPiece(int rowIdx, int colIdx) {
        if (!isValid(rowIdx) || !isValid(colIdx)) {
            return null;
        }

        return pieces[rowIdx][colIdx];
    }

    private boolean isValid(int location) {
        return location >= 0 && MAX_SIZE > location;
    }

    public int size() {
        return MAX_SIZE * MAX_SIZE;
    }

    public int pieceCount() {
        int count = 0;
        for (int row = 0; row < MAX_SIZE; row++) {
            for (int column = 0; column < MAX_SIZE; column++) {
                if (pieces[row][column] != null) {
                    count++;
                }
            }
        }
        return count;
    }
}
