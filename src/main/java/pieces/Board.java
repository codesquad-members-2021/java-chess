package pieces;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> board = new ArrayList<>();

    void add(Pawn pawn) {
        board.add(pawn);
    }

    int size() {
        return board.size();
    }

    Pawn findPawn(int index) {
        return board.get(index);
    }
}
