package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Pawn> pawnList;

    public Board(){
        pawnList = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int size() {
        return pawnList.size();
    }

    public Pawn findPawn(int i) {
        return pawnList.get(i);
    }
}

