package net.isaac.chess;

import net.isaac.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int MAX_SIZE = 8;

    private Pawn[][] pawns = new Pawn[MAX_SIZE][MAX_SIZE];

    public boolean add(Pawn pawn, int rowIdx, int colIdx){
        if(!isValid(rowIdx) || !isValid(colIdx))
            return false;

        pawns[rowIdx][colIdx] = pawn;
        return true;
    }

    public Pawn findPawn(int rowIdx, int colIdx){
        if(!isValid(rowIdx) || !isValid(colIdx))
            return null;

        return pawns[rowIdx][colIdx];
    }

    private boolean isValid(int location){
        if(location < 0 || MAX_SIZE <= location)
            return false;
        else
            return true;
    }

    public int size(){
        return MAX_SIZE*MAX_SIZE;
    }
}
