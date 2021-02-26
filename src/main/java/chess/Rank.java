package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;

import java.util.ArrayList;
import java.util.List;

import static chess.Board.*;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>(8);

    private Rank() {
    }

    public static Rank initWhitePieceRank() {
        Rank rank = new Rank();
        rank.add(Piece.createWhiteRook(new Position("a1")));
        rank.add(Piece.createWhiteKnight(new Position("b1")));
        rank.add(Piece.createWhiteBishop(new Position("c1")));
        rank.add(Piece.createWhiteQueen(new Position("d1")));
        rank.add(Piece.createWhiteKing(new Position("e1")));
        rank.add(Piece.createWhiteBishop(new Position("f1")));
        rank.add(Piece.createWhiteKnight(new Position("g1")));
        rank.add(Piece.createWhiteRook(new Position("h1")));

        return rank;
    }

    public static Rank initWhitePawnRank(int rankNum) {
        Rank boardRank = new Rank();
        for (int i = 0; i < BOARD_FILE; i++) {
            char file = (char) ('a' + i);
            char rank = (char) (rankNum + '0');
            String position = file + "" + rank;
            boardRank.add(Piece.createWhitePawn(new Position(position)));
        }
        return boardRank;
    }

    public static Rank initBlackPawnRank(int rankNum) {
        Rank boardRank = new Rank();
        for (int i = 0; i < BOARD_FILE; i++) {
            char file = (char) ('a' + i);
            char rank = (char) (rankNum + '0');
            String position = file + "" + rank;
            boardRank.add(Piece.createBlackPawn(new Position(position)));
        }
        return boardRank;
    }

    public static Rank initBlackPieceRank() {
        Rank rank = new Rank();
        rank.add(Piece.createBlackRook(new Position("a8")));
        rank.add(Piece.createBlackKnight(new Position("b8")));
        rank.add(Piece.createBlackBishop(new Position("c8")));
        rank.add(Piece.createBlackQueen(new Position("d8")));
        rank.add(Piece.createBlackKing(new Position("e8")));
        rank.add(Piece.createBlackBishop(new Position("f8")));
        rank.add(Piece.createBlackKnight(new Position("g8")));
        rank.add(Piece.createBlackRook(new Position("h8")));

        return rank;
    }

    public static Rank initBlankRank(int rankNum) {
        Rank boardRank = new Rank();
        for (int i = 0; i < BOARD_FILE; i++) {
            char file = (char) ('a' + i);
            char rank = (char) (rankNum + '0');
            String position = file + "" + rank;
            boardRank.add(Piece.createBlank(new Position(position)));
        }
        return boardRank;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public void setPiece(int index, Piece piece) {
        pieceList.add(index, piece);
    }

    public void remove(int index) {
        pieceList.remove(index);
    }

    public long count(Color color, Type type) {
        return pieceList.stream()
                .filter(x -> x.getColor() == color)
                .filter(x -> x.getType() == type)
                .count();
    }
}
