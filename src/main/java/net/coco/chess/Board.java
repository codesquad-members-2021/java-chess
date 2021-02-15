package net.coco.chess;

import net.coco.pieces.Pawn;
import net.coco.pieces.PawnEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();


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
