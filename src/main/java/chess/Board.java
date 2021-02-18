package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();
    private int BOARD_SIZE = 8;

    public void addWhitePawn(Pawn pawn){
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn){
        blackPawns.add(pawn);
    }

    public Pawn findWhitePawn(int index){
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index){
        return blackPawns.get(index);
    }

    public void initialize(){
        for(int i =0; i<BOARD_SIZE; i++){
            addWhitePawn(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addBlackPawn(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult(){
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult(){
        return getPawnsResult(blackPawns);
    }

    public int size(){
        return blackPawns.size()+ whitePawns.size();
    }

    private String getPawnsResult(List<Pawn> pawns){
        StringBuilder pawnsResult = new StringBuilder();
        for(Pawn pawn : pawns)
            pawnsResult.append(pawn.getRepresentation());
        return pawnsResult.toString();
    }
}
