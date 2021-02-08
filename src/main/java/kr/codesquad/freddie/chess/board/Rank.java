package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    public static final int SIZE = 8;
    private List<Pawn> pawns = new ArrayList<>();

    public Rank() {
    }

    public void add(Pawn pawn) {
        if (size() == SIZE) {
            throw new IllegalArgumentException("랭크 당 8개만 추가 가능합니다.");
        }

        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }
}
