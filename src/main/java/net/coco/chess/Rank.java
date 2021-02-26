package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.pieces.Piece.Color;
import net.coco.pieces.PieceType;

import java.util.*;
import java.util.stream.Collectors;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public List<Piece> getPieces() {
        return Collections.unmodifiableList(pieces);
        //piece 변경가능
    }


    public static Rank initBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook())
                .addPiece(Piece.createBlackKnight())
                .addPiece(Piece.createBlackBishop())
                .addPiece(Piece.createBlackQueen())
                .addPiece(Piece.createBlackKing())
                .addPiece(Piece.createBlackBishop())
                .addPiece(Piece.createBlackKnight())
                .addPiece(Piece.createBlackRook());
        return rank;
    }

    public static Rank initWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook())
                .addPiece(Piece.createWhiteKnight())
                .addPiece(Piece.createWhiteBishop())
                .addPiece(Piece.createWhiteQueen())
                .addPiece(Piece.createWhiteKing())
                .addPiece(Piece.createWhiteBishop())
                .addPiece(Piece.createWhiteKnight())
                .addPiece(Piece.createWhiteRook());
        return rank;
    }

    public static Rank initWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_CELLS; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
        return rank;
    }

    public static Rank initBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_CELLS; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }
        return rank;
    }

    public static Rank initBlankLine() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_CELLS; i++) {
            rank.addPiece(Piece.createBlank());
        }
        return rank;
    }

    private Rank addPiece(Piece piece) {
        pieces.add(piece);
        return this;
    }

    public int findPieceCount(PieceType pieceType, Color color) {
        return (int) pieces.stream()
                .filter(piece -> piece.getPieceType() == pieceType)
                .filter(piece -> piece.getColor() == color)
                .count();
    }

    public Piece findPieceFromPoint(int column) {
        return pieces.get(column);
    }

    public void movePieceToPoint(Piece piece, int row) {
        pieces.set(row, piece);
    }

    public Piece findPieceByColumn(Color color, int column) {
        Piece findPiece = pieces.get(column);
        return findPiece.getColor() == color ? findPiece : Piece.createBlank();
    }

    public List<Piece> getWhitePieces() {
        return pieces.stream().filter(Piece::isWhite).collect(Collectors.toList());
    }

    public List<Piece> getBlackPieces() {
        return pieces.stream().filter(Piece::isBlack).collect(Collectors.toList());
    }
}
