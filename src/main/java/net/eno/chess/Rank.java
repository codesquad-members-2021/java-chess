package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private final List<Piece> rank;

    private Rank() {
        rank = new ArrayList<>();
    }

    public static Rank createOnePieceRank(Color color, PieceType pieceType) {
        Rank rank = new Rank();
        for (int file = 0; file < 8; file++) {
            rank.addPiece(Piece.createPiece(color, pieceType));
        }
        return rank;
    }

    public static Rank createMultiplePieceRank(Color color) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createPiece(color, PieceType.ROOK));
        rank.addPiece(Piece.createPiece(color, PieceType.KNIGHT));
        rank.addPiece(Piece.createPiece(color, PieceType.BISHOP));
        rank.addPiece(Piece.createPiece(color, PieceType.QUEEN));
        rank.addPiece(Piece.createPiece(color, PieceType.KING));
        rank.addPiece(Piece.createPiece(color, PieceType.BISHOP));
        rank.addPiece(Piece.createPiece(color, PieceType.KNIGHT));
        rank.addPiece(Piece.createPiece(color, PieceType.ROOK));
        return rank;
    }

    private void addPiece(Piece piece) {
        rank.add(piece);
    }

    public int countPiece() {
        int count = 0;
        for (Piece piece : this.rank) {
            if (piece.getRepresentation(Color.WHITE) != '.') {
                count++;
            }
        }
        return count;
    }

    public int countTargetPiece(Color color, PieceType pieceType) {
        int count = 0;
        for (Piece piece : this.rank) {
            if (piece.getColor().equals(color) && piece.getPieceType().equals(pieceType)) {
                count++;
            }
        }
        return count;
    }

    public Piece findPiece(int fileIndex) {
        return this.rank.get(fileIndex);
    }

    public void move(int fileIndex, Piece piece) {
        this.rank.set(fileIndex, piece);
    }

    public double calculateRankPoint(Color color) {
        double point = 0;
        for (Piece piece : this.rank) {
            if (piece.getColor().equals(color)) {
                point += piece.getPoint();
            }
        }
        return point;
    }

    public List<Piece> getPieceListByColor(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Piece piece : this.rank) {
            if (piece.getColor().equals(color)) {
                pieceList.add(piece);
            }
        }
        return pieceList;
    }

    public String showRank(Color color) {
        StringBuilder result = new StringBuilder();
        int reverseFIle = color.equals(Color.BLACK) ? 7 : 0;
        for (int file = 0; file < this.rank.size(); file++) {
            Piece piece = rank.get(Math.abs(file - reverseFIle));
            result.append(piece.getRepresentation(piece.getColor()));
        }
        return result.toString();
    }

}
