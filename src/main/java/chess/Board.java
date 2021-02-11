package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private static final int PAWNSNUM = 8;
    private static final int COLUMN = 8;
    private List<Pawn> whitePawns = new ArrayList<>(8);
    private List<Pawn> blackPawns = new ArrayList<>(8);
    private List<List<Pawn>> board = new ArrayList(8);

    public void add(Pawn pawn) {
        List list = distinguish(pawn);
        list.add(pawn);
    }

    public List distinguish(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            return whitePawns;
        }
        if (pawn.getColor().equals(Pawn.BLACK_COLOR)) {
            return blackPawns;
        }
        return null;
    }


    public int size(Pawn pawn) {
        return distinguish(pawn).size();
    }

    public Pawn findPawn(Pawn pawn, int idx) {
        return (Pawn) distinguish(pawn).get(idx);
    }

    public void initialize() {

    }

    public void print() {
        System.out.println(board.toString());
    }

    public String getWhitePawnResult() {

    }

    public String getBlackPawnResult() {
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();
        board.getWhitePawnResult();
        board.print();
    }
}
