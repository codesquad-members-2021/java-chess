package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;

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

    public Piece findPiece(int i) {
        return this.rank.get(i);
    }

    public void move(int i, Piece piece) {
        this.rank.set(i, piece);
    }

    public static Rank createWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            String position = String.valueOf((char)('a' + i)) + 2;
            rank.addPiece(Piece.createPiece(PieceType.WHITE_PAWN, new Position(position)));
        }
        return rank;
    }

    public static Rank createBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            String position = String.valueOf((char)('a' + i)) + 7;
            rank.addPiece(Piece.createPiece(PieceType.BLACK_PAWN, new Position(position)));
        }
        return rank;
    }

    public static Rank createWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createPiece(PieceType.WHITE_ROOK, new Position("a1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_KNIGHT, new Position("b1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_BISHOP, new Position("c1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_QUEEN, new Position("d1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_KING, new Position("e1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_BISHOP, new Position("f1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_KNIGHT, new Position("g1")));
        rank.addPiece(Piece.createPiece(PieceType.WHITE_ROOK, new Position("h1")));
        return rank;
    }

    public static Rank createBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createPiece(PieceType.BLACK_ROOK, new Position("a8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_KNIGHT, new Position("b8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_BISHOP, new Position("c8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_QUEEN, new Position("d8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_KING, new Position("e8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_BISHOP, new Position("f8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_KNIGHT, new Position("g8")));
        rank.addPiece(Piece.createPiece(PieceType.BLACK_ROOK, new Position("h8")));
        return rank;
    }

    public static Rank createBlankLine(int rankNumber) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            String position = String.valueOf((char)('a' + i)) + rankNumber;
            rank.addPiece(Piece.createPiece(PieceType.NO_PIECE, new Position(position)));
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
