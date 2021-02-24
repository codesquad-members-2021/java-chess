package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private final List<Piece> rank;

    private Rank() {
        rank = new ArrayList<>();
    }

    public static Rank createOnePieceRank(int rankNumber, Color color, PieceType pieceType) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            String position = String.valueOf((char)('a' + i)) + rankNumber;
            rank.addPiece(Piece.createPiece(color, pieceType, new Position(position)));
        }
        return rank;
    }

    public static Rank createMultiplePieceRank(int rankNumber, Color color) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createPiece(color, PieceType.ROOK, new Position("a" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.KNIGHT, new Position("b" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.BISHOP, new Position("c" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.QUEEN, new Position("d" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.KING, new Position("e" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.BISHOP, new Position("f" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.KNIGHT, new Position("g" + rankNumber)));
        rank.addPiece(Piece.createPiece(color, PieceType.ROOK, new Position("h" + rankNumber)));
        return rank;
    }

    private void addPiece(Piece piece) {
        rank.add(piece);
    }

    public int pieceCount() {
        int count = 0;
        for (Piece piece : this.rank) {
            if (piece.getRepresentation(Color.WHITE) != '.') {
                count++;
            }
        }
        return count;
    }

    public int targetPieceCount(Color color, PieceType pieceType) {
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

    public String showRank(Color color) {
        StringBuilder result = new StringBuilder();
        int reverseRank = color.equals(Color.BLACK) ? 7 : 0;
        for (int rankNumber = 0; rankNumber < this.rank.size(); rankNumber++) {
            Piece piece = rank.get(Math.abs(rankNumber - reverseRank));
            result.append(piece.getRepresentation(piece.getColor()));
        }
        return result.toString();
    }

}
