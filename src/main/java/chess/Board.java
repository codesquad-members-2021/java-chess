package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pieces.Piece.Color;
import pieces.Piece.Type;

public class Board {

    private final List<Rank> board = new ArrayList<>();

    public int sizeofPieces(Color color, Type type) {
        int count = 0;
        for (Rank rank : board) {
            count += rank.countPieces(color, type);
        }
        return count;
    }

    public void initialize() {
        board.add(Rank.initializeWhitePieces());
        board.add(Rank.initializeWhitePawns());
        board.add(Rank.initializeBlankLine());
        board.add(Rank.initializeBlankLine());
        board.add(Rank.initializeBlankLine());
        board.add(Rank.initializeBlankLine());
        board.add(Rank.initializeBlackPawns());
        board.add(Rank.initializeBlackPieces());
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

}
