package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Position;
import chess.pieces.Type;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private List<Piece> pieces = new ArrayList<>(Board.BOARD_SIZE);

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(int rankIndex) {
        return pieces.get(rankIndex);
    }

    public void addWhitePieces(Piece piece) {
        if (piece.isWhite()) {
            pieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    public void addBlackPieces(Piece piece) {
        if (piece.isBlack()) {
            pieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    public void addBlank(Piece piece) {
        if (piece.getType() == Type.BLANK) {
            pieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    public void move(int position, Piece piece) {
        pieces.set(position, piece);
    }

    private void getAddErrorMessage() {
        System.out.println("알 수 없는 color의 piece입니다.");
        System.out.println("add에 실패하였습니다.");
    }

    public static Rank initializeWhitePieces(int fileIndex) {
        Rank rank = new Rank();
        rank.addWhitePieces(Piece.createWhiteRook(new Position(8, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteKnight(new Position(7, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteBishop(new Position(6, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteQueen(new Position(5, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteKing(new Position(4, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteBishop(new Position(3, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteKnight(new Position(2, fileIndex)));
        rank.addWhitePieces(Piece.createWhiteRook(new Position(1, fileIndex)));

        return rank;
    }

    public static Rank initializeWhitePawns(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addWhitePieces(Piece.createWhitePawn(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public static Rank initializeBlackPieces(int fileIndex) {
        Rank rank = new Rank();
        rank.addBlackPieces(Piece.createBlackRook(new Position(8, fileIndex)));
        rank.addBlackPieces(Piece.createBlackKnight(new Position(7, fileIndex)));
        rank.addBlackPieces(Piece.createBlackBishop(new Position(6, fileIndex)));
        rank.addBlackPieces(Piece.createBlackQueen(new Position(5, fileIndex)));
        rank.addBlackPieces(Piece.createBlackKing(new Position(4, fileIndex)));
        rank.addBlackPieces(Piece.createBlackBishop(new Position(3, fileIndex)));
        rank.addBlackPieces(Piece.createBlackKnight(new Position(2, fileIndex)));
        rank.addBlackPieces(Piece.createBlackRook(new Position(1, fileIndex)));

        return rank;
    }

    public static Rank initializeBlackPawns(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addBlackPieces(Piece.createBlackPawn(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public static Rank initializeBlank(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addBlank(Piece.createBlank(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public static Rank initializeAllBlank(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addBlank(Piece.createBlank(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public int getCountPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;

        for (Piece piece : pieces) {
            if (piece.matchColorAndType(color, type)) {
                countPiece += 1;
            }
        }

        return countPiece;
    }

    public List<Piece> findPieceByColor(Color color) {
        List<Piece> pieceByColor = new ArrayList<>(Board.BOARD_SIZE);

        for (Piece piece : pieces) {
            if (piece.matchColor(color)) {
                pieceByColor.add(piece);
            }
        }

        return pieceByColor;
    }
}
