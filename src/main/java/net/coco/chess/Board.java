package net.coco.chess;

import net.coco.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void addPawn(Pawn pawn){
        pawns.add(pawn);
    }
    public int size(){
        return pawns.size();
    }
    public Pawn findPawn(int index){
        return pawns.get(index);
    }
}
