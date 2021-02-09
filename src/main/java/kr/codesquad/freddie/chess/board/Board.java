package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    // 체스에서 row를 rank라고 한다.
    public static final int RANK_SIZE = 8;
    private List<File> files = new ArrayList<>();

    public Board() {
        for (int i = 0; i < RANK_SIZE; i++) {
            files.add(new File());
        }
    }

    public void add(Pawn pawn) {
        for (File file : files) {
            if (file.size() < File.SIZE) {
                file.add(pawn);
                return;
            }
        }

        if (RANK_SIZE * File.SIZE == size()) {
            throw new IllegalArgumentException("더 이상 추가할 수 없습니다. 현재 크기 : " + size());
        }
    }

    public int size() {
        return files.stream()
                .mapToInt(File::size)
                .sum();
    }
}
