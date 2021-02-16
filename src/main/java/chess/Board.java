package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private ArrayList<Pawn> whitePawnList = new ArrayList<>();
    private ArrayList<Pawn> blackPawnList = new ArrayList<>();

    private String nullLine = "* * * * * * * *";


    public void add(Pawn pawn){
        if(pawn.getColor() == Pawn.Color.WHITE){

            whitePawnList.add(pawn);
        }else{
            blackPawnList.add(pawn);
        }
    }

    public int size(){
        return whitePawnList.size() + blackPawnList.size();
    }

    public void initialize(){
        for(int i = 0; i < 8; i++){
            whitePawnList.add(new Pawn());
            blackPawnList.add(new Pawn(Pawn.Color.BLACK, 'P'));
        }
    }

    public String getWhitePawnResult(){
        return getPawnRepresentation(whitePawnList);
    }

    public String getBlackPawnResult(){
        return getPawnRepresentation(blackPawnList);
    }

    private String getPawnRepresentation(ArrayList<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            sb.append(pawn.getRepresentation());
            sb.append(" ");
        }
        return sb.toString();
    }

    public void print(){
        StringBuilder sb = new StringBuilder();

        System.out.println(nullLine);
        System.out.println(getBlackPawnResult());
        System.out.println(nullLine);
        System.out.println(nullLine);
        System.out.println(nullLine);
        System.out.println(nullLine);
        System.out.println(getWhitePawnResult());
        System.out.println(nullLine);
    }
    
}
