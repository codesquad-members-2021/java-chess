package net.jung.chess;

import net.jung.chess.pieces.Pawn;

import java.util.*;

public class Board {
    private List<Pawn> blackPawnList = new ArrayList();
    private List<Pawn> whitePawnList = new ArrayList();

    public void add(Pawn pawn) {
        if(pawn.getColor().equals(Color.WHITE)){
            whitePawnList.add(pawn);
        }else{
            blackPawnList.add(pawn);
        }
    }

    public int size(){
        return whitePawnList.size()+blackPawnList.size();
    }

    public Pawn findWhitePawn(int index){
            return whitePawnList.get(index);
        }

    public Pawn findBlackPawn(int index){
            return blackPawnList.get(index);
        }

}
