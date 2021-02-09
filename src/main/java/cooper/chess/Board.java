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
            throw new IndexOutOfBoundsException("board size == 0입니다.");
        }

        if ((0 > index) || (index <= pawnList.size())) {
            throw new IndexOutOfBoundsException("인덱스의 범위를 벗어났습니다");
        }

        return pawnList.get(index);
    }
}