package net.woody.chess;

import net.woody.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Piece find(int file) {
        validateFileIndex(file);
        return pieces.get(file);
    }

    public int size() {
        int pieceSize = 0;
        for (Piece piece : pieces) {
            pieceSize += piece.equals(Piece.getBlankInstance()) ? 0 : 1;
        }
        return pieceSize;
    }

    // TODO : 예외처리 클라이언트가 이해할 수 있는 최상단의 예외로 던져주자
    private void validateFileIndex(int file) {
        if (file < 0 || BOARD_LENGTH <= file) {
            throw new ArrayIndexOutOfBoundsException("File number " + file + " is out of range!");
        }
    }

    private static Rank createRank(List<Piece> pieces) {
        return new Rank(pieces);
    }

    public static Rank createBlankRank() {
        ArrayList<Piece> pieces = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(Piece.getBlankInstance());
        }
        return createRank(pieces);
    }

    public static Rank createWhitePawnRank() {
        ArrayList<Piece> pieces = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(Piece.createWhitePawn());
        }
        return createRank(pieces);
    }

    public static Rank createBlackPawnRank() {
        ArrayList<Piece> pieces = new ArrayList<>(BOARD_LENGTH);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(Piece.createBlackPawn());
        }
        return createRank(pieces);
    }

    public static Rank createBlackPieceRank() {
        return createRank(blackPieces());
    }

    public static Rank createWhitePieceRank() {
        return createRank(whitePieces());
    }

    private static List<Piece> blackPieces() {
        return Stream.of(
                Piece.createBlackRook(),
                Piece.createBlackKnight(),
                Piece.createBlackBishop(),
                Piece.createBlackQueen(),
                Piece.createBlackKing(),
                Piece.createBlackBishop(),
                Piece.createBlackKnight(),
                Piece.createBlackRook()
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<Piece> whitePieces() {
        return Stream.of(
                Piece.createWhiteRook(),
                Piece.createWhiteKnight(),
                Piece.createWhiteBishop(),
                Piece.createWhiteQueen(),
                Piece.createWhiteKing(),
                Piece.createWhiteBishop(),
                Piece.createWhiteKnight(),
                Piece.createWhiteRook()
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        // TODO : sb 네이밍 바꾸기
        StringBuilder sb = new StringBuilder();
        if (pieces.size() == 0) {
            return "........";
        }
        // TODO : for-loop을 풀어적거나
        pieces.forEach(piece -> sb.append(piece.getRepresentation()));
        return sb.toString();
    }
}
