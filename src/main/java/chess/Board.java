package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private List<Pawn> whitePawnList = new ArrayList<>();
    private List<Pawn> blackPawnList = new ArrayList<>();

    private String nullLine = "* * * * * * * *";

    private final int PAWNCOUNT = 8;

    public Pawn findPawn(Pawn.Color color, int index){
        if(color == Pawn.Color.WHITE){
            return whitePawnList.get(index);
        }
        return blackPawnList.get(index);
    }

    public void add(Pawn pawn){
        if(pawn.getColor() == Pawn.Color.WHITE){
            whitePawnList.add(pawn);
        }
        blackPawnList.add(pawn);
    }

    public int size(){
        return whitePawnList.size() + blackPawnList.size();
    }

    public void initialize(){
        for(int i = 0; i < PAWNCOUNT; i++){
            whitePawnList.add(new Pawn());
            blackPawnList.add(new Pawn(Pawn.Color.BLACK));
        }
    }

    public String getWhitePawnResult(){
        return getPawnRepresentation(whitePawnList);
    }

    public String getBlackPawnResult(){
        return getPawnRepresentation(blackPawnList);
    }

    private String getPawnRepresentation(ArrayList<Pawn> pawnList) {
        StringBuilder sb = new StringBuilder();

        for (Pawn pawn : pawnList) {
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
