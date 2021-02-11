package cooper.chess;
import cooper.chess.piece.Pawn;

import java.util.*;

public class Board {
    private final List<Pawn> pawnList;

    public Board() {
        pawnList = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int size() {
        return pawnList.size();
    }

    public Pawn findPawn(int number) {
        int index = number - 1;

        if(pawnList.size() == 0) {
            throw new IndexOutOfBoundsException("사이즈가 0 입니다.");
        }

        if ((0 > number) || (number > pawnList.size())) {
            throw new ArrayIndexOutOfBoundsException("범위를 벗어나는 인덱스 입니다.");
        }

        return pawnList.get(index);
    }
}