package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Piece> board = new ArrayList<>();

    public void add(Piece piece) {
        board.add(piece);
    }

    public int size() {
        return board.size();
    }

    public Piece findPawn(int index) {
        return board.get(index);
    }

    public void initialize() {
    }

    public String getWhitePawnsResult() {
        return "";
    }

    public String getBlackPawnsResult() {
        return "";
    }
}
