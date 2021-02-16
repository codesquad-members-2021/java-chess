package chess;

import pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private ArrayList<Pawn> whitePawnList = new ArrayList<>();
    private ArrayList<Pawn> blackPawnList = new ArrayList<>();

    private String nullLine = "* * * * * * * *";

    public Pawn findPawn(Pawn.Color color, int index){

        if(color == Pawn.Color.WHITE){
            return whitePawnList.get(index);
        }else {
            return blackPawnList.get(index);
        }

    }

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
        sb.append(nullLine);
        sb.append('\n');
        sb.append(getBlackPawnResult());
        sb.append('\n');
        sb.append(nullLine);
        sb.append('\n');
        sb.append(nullLine);
        sb.append('\n');
        sb.append(nullLine);
        sb.append('\n');
        sb.append(nullLine);
        sb.append('\n');
        sb.append(getWhitePawnResult());
        sb.append('\n');
        sb.append(nullLine);
        System.out.println(sb.toString());
    }
    
}
