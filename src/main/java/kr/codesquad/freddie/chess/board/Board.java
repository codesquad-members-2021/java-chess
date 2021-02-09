package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    // 체스에서 column을 file이라고 한다.
    public static final int FILE_SIZE = 8;
    private List<Rank> ranks = new ArrayList<>();

    public Board() {
        for (int i = 0; i < FILE_SIZE; i++) {
            ranks.add(new Rank());
        }
    }

    public void add(Pawn pawn) {
        for (Rank rank : ranks) {
            if (rank.size() < Rank.SIZE) {
                rank.add(pawn);
                return;
            }
        }

        if (FILE_SIZE * Rank.SIZE == size()) {
            throw new IllegalArgumentException("더 이상 추가할 수 없습니다. 현재 크기 : " + size());
        }
    }

    public int size() {
        return ranks.stream()
                .mapToInt(Rank::size)
                .sum();
    }
}
