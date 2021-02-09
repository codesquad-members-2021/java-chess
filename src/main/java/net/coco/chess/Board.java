package net.coco.chess;

import net.coco.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns = new ArrayList<>();

    public void addPawn(Pawn pawn){
        pawns.add(pawn);
    }

}
