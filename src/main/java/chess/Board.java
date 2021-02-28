package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.Color;
import piece.Type;
import piece.Position;

public class Board {
    private final List<Rank> board = new ArrayList<>();

    public List<Rank> getBoard() {
        return board;
    }

    public int countPieces(Color color, Type type) {
        int count = 0;
        for (Rank rank : board) {
            count += rank.countPieces(color, type);
        }
        return count;
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            board.add(Rank.initializeBlankLine(i));
        }
    }

    public void initialize() {
        board.add(Rank.initializeWhitePieces(0));
        board.add(Rank.initializeWhitePawns(1));
        board.add(Rank.initializeBlankLine(2));
        board.add(Rank.initializeBlankLine(3));
        board.add(Rank.initializeBlankLine(4));
        board.add(Rank.initializeBlankLine(5));
        board.add(Rank.initializeBlackPawns(6));
        board.add(Rank.initializeBlackPieces(7));
    }

    public Piece findPiece(String position) {
        Position p = new Position(position);
        Rank rank = board.get(p.getYIndex());
        return rank.findPiece(p.getXIndex());
    }

    public void move(String positionStr, Piece piece) {
        Position position = new Position(positionStr);
        Rank rank = board.get(position.getYIndex());
        rank.move(position.getXIndex(), piece);
    }

    public double calculatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getPoint(pieces);
        }
        return point;
    }

    public List<Piece> findPiecesByColor(Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Rank rank : board) {
            pieces.addAll(rank.findPiecesByColor(color));
        }
        return pieces;
    }

}
