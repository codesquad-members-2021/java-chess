package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.valid.PieceValid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public int size() {
        return pieces.size();
    }

    public void clear() {
        pieces.clear();
    }

    public List<Piece> getPieces() {
        return Collections.unmodifiableList(pieces);
    }

    public static Rank initBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());
        return rank;
    }

    public static Rank initWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());
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

    private void addPiece(Piece piece) {
        pieces.add(piece);
    }
}
