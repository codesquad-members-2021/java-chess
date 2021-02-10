package net.honux.chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn){
        pawns.add(pawn);
    }

    public int size(){
        return pawns.size();
    }
}
