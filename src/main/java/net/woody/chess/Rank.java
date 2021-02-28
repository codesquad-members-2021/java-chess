package net.woody.chess;

import net.woody.pieces.Piece;

import java.util.List;

import static net.woody.factories.PieceFactory.*;

public class Rank {
    private static final int BOARD_LENGTH = 8;

    private final List<Piece> pieces;

    private Rank(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void add(int file, Piece piece) {
        validateFileIndex(file);
        pieces.set(file, piece);
    }

    public Piece getPiece(int file) {
        validateFileIndex(file);
        return pieces.get(file);
    }

    public int getNumOfPiece(Piece target) {
        int targetCounter = 0;
        for (Piece piece : pieces) {
            targetCounter += target.equals(piece) ? 1 : 0;
        }
        return targetCounter;
    }

    public int size() {
        int pieceSize = 0;
        for (Piece piece : pieces) {
            pieceSize += piece.equals(getBlankInstance()) ? 0 : 1;
        }
        return pieceSize;
    }

    // TODO : 예외처리 클라이언트가 이해할 수 있는 최상단의 예외로 던져주자
    private void validateFileIndex(int file) {
        if (file < 0 || BOARD_LENGTH <= file) {
            throw new ArrayIndexOutOfBoundsException("File number " + file + " is out of range!");
        }
    }

    public static Rank createRank(List<Piece> pieces) {
        return new Rank(pieces);
    }

    @Override
    public String toString() {
        StringBuilder rank = new StringBuilder();

        // TODO : for-loop을 풀어적거나
        for (Piece piece : pieces) {
            rank.append(piece.getRepresentation());
        }
        return rank.toString();
    }
}
