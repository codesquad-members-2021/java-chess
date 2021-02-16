package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> whitePawnList = new ArrayList<>();
    private List<Pawn> blackPawnList = new ArrayList<>();

    public void add(Pawn pawn){
        whitePawnList.add(pawn);
        blackPawnList.add(pawn);
    }

    public int size(){
        return whitePawnList.size() + blackPawnList.size();
    }

    public Pawn findPawn(int i){
        return blackPawnList.get(i);
    }

    public void initialize(){
        for(int i = 0; i < 8; i++){
            blackPawnList.add(new Pawn());

        }
    }

    public void print(){

    }
    
}
