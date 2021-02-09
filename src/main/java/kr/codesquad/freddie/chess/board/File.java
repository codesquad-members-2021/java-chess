package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;

public class File {
    public static final int SIZE = 8;
    private List<Pawn> pawns = new ArrayList<>();

    public File() {
    }

    public void add(Pawn pawn) {
        if (size() == SIZE) {
            throw new IllegalArgumentException("파일 당 8개만 추가 가능합니다.");
        }

        pawns.add(pawn);
    }

    public Pawn get(char fileIndex) {
        return pawns.get(fileIndex - 'a');
    }

    public int size() {
        return pawns.size();
    }
}
