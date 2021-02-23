package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    List<Piece> rank = new ArrayList<>();

    private void addPiece(Piece piece) {
        rank.add(piece);
    }

    public int pieceCount() {
        int count = 0;
        for (Piece piece : this.rank) {
            if (piece.getRepresentation() != '.') {
                count++;
            }
        }
        return count;
    }

    public int targetPieceCount(PieceType pieceType) {
        int count = 0;
        for (Piece piece : this.rank) {
            if (piece.getPieceType().equals(pieceType)) {
                count++;
            }
        }
        return count;
    }

    public static Rank createWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createPiece(PieceType.WHITE_PAWN));
        }
        return rank;
    }

    public static Rank createBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createPiece(PieceType.BLACK_PAWN));
        }
        return rank;
    }

    public static Rank createWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createPiece(PieceType.WHITE_ROOK));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_KNIGHT));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_BISHOP));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_QUEEN));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_KING));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_BISHOP));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_KNIGHT));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_ROOK));
        return rank;
    }

    public static Rank createBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createPiece(PieceType.BLACK_ROOK));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_KNIGHT));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_BISHOP));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_QUEEN));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_KING));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_BISHOP));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_KNIGHT));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_ROOK));
        return rank;
    }

    public static Rank createBlankLine() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.createPiece(PieceType.NO_PIECE));
        }
        return rank;
    }

    public String getPiecesResult(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.rank.size(); i++) {
            result.append(rank.get(Math.abs(i - num)).getRepresentation());
        }
        return result.toString();
    }

}
