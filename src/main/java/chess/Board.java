package chess;

import pieces.Pawn;
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

    public Piece findPawn(int i) {
        return board.get(i);
    }
}
