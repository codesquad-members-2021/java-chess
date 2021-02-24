package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Position;
import chess.pieces.Type;

import java.util.ArrayList;
import java.util.List;

import static chess.pieces.Piece.*;

public class Rank {

    private List<Piece> pieces = new ArrayList<>(Board.BOARD_SIZE);
    private final int RANK_INDEX = 8;

    public List<Piece> getRank() {
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
        rank.addWhitePieces(createWhiteRook(new Position(rank.RANK_INDEX, fileIndex)));
        rank.addWhitePieces(createWhiteKnight(new Position(rank.RANK_INDEX - 1, fileIndex)));
        rank.addWhitePieces(createWhiteBishop(new Position(rank.RANK_INDEX - 2, fileIndex)));
        rank.addWhitePieces(createWhiteQueen(new Position(rank.RANK_INDEX - 3, fileIndex)));
        rank.addWhitePieces(createWhiteKing(new Position(rank.RANK_INDEX - 4, fileIndex)));
        rank.addWhitePieces(createWhiteBishop(new Position(rank.RANK_INDEX - 5, fileIndex)));
        rank.addWhitePieces(createWhiteKnight(new Position(rank.RANK_INDEX - 6, fileIndex)));
        rank.addWhitePieces(createWhiteRook(new Position(rank.RANK_INDEX - 7, fileIndex)));

        return rank;
    }

    public static Rank initializeWhitePawns(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addWhitePieces(createWhitePawn(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public static Rank initializeBlackPieces(int fileIndex) {
        Rank rank = new Rank();
        rank.addBlackPieces(createBlackRook(new Position(rank.RANK_INDEX, fileIndex)));
        rank.addBlackPieces(createBlackKnight(new Position(rank.RANK_INDEX - 1, fileIndex)));
        rank.addBlackPieces(createBlackBishop(new Position(rank.RANK_INDEX - 2, fileIndex)));
        rank.addBlackPieces(createBlackQueen(new Position(rank.RANK_INDEX - 3, fileIndex)));
        rank.addBlackPieces(createBlackKing(new Position(rank.RANK_INDEX - 4, fileIndex)));
        rank.addBlackPieces(createBlackBishop(new Position(rank.RANK_INDEX - 5, fileIndex)));
        rank.addBlackPieces(createBlackKnight(new Position(rank.RANK_INDEX - 6, fileIndex)));
        rank.addBlackPieces(createBlackRook(new Position(rank.RANK_INDEX - 7, fileIndex)));

        return rank;
    }

    public static Rank initializeBlackPawns(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addBlackPieces(createBlackPawn(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public static Rank initializeBlank(int fileIndex) {
        Rank rank = new Rank();
        for (int rankIndex = 0; rankIndex < Board.BOARD_SIZE; rankIndex++) {
            rank.addBlank(createBlank(new Position(rankIndex, fileIndex)));
        }
        return rank;
    }

    public int getCountPiecesByColorAndType(Color color, Type type) {
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
