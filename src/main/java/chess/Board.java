package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class Board {

    private final List<Rank> board = new ArrayList<>();

    public int sizeofPieces(Color color, Type type) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListIterator<Rank> rankIter = board.listIterator(board.size());
        while (rankIter.hasPrevious()) {
            sb.append(rankIter.previous().toString());
        }
        return sb.toString();
    }

    public Piece findPiece(String position) {
        Position p = new Position(position);
        Rank rank = board.get(p.getYPos());
        return rank.findPiece(p.getXPos());
    }

    public void move(String positionStr, Piece piece) {
        Position position = new Position(positionStr);
        Rank rank = board.get(position.getYPos());
        rank.move(position.getXPos(), piece);
    }
}
