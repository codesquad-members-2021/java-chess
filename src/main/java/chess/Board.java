package chess;

import java.util.*;

public class Board {
    private List<Pawn> pawnList = new ArrayList();

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }
}
