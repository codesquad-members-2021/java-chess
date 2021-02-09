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

    /**
     * 체스판의 file은 column으로, 좌측부터 a에서 시작하여 h까지의 알파벳 인덱스로 매겨진다.
     * 첫 번째 칸 a는 array의 인덱스로 생각했을 때 0과 같고, h는 7과 같다.
     * 예를 들어 가장 좌측의 기물을 가져오려면 get('a') 와 같이 사용할 수 있다.
     * @param fileIndex a~h 사이의 char
     * @return 해당 칸에 존재하는 기물
     * @see Board#findPawn(char, int)
     */
    public Pawn get(char fileIndex) {
        return pawns.get(fileIndex - 'a');
    }

    public int size() {
        return pawns.size();
    }
}
