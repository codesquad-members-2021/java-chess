package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Piece> board;

    public Board() {
        this.board = new ArrayList<>();
    }

    public void add(Piece piece) {
        board.add(piece);
    }

    public int size() {
        return board.size();
    }

    public Piece findPawn(int index) {
        return board.get(index);
    }
}
