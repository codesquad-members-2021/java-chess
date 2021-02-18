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
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult(){
        StringBuilder whitePawnsResult = new StringBuilder();
        for(Pawn whitePawn : whitePawns)
            whitePawnsResult.append(whitePawn.getRepresentation());

        return whitePawnsResult.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder blackPawnsResult = new StringBuilder();
        for(Pawn blackPawn : blackPawns)
            blackPawnsResult.append(blackPawn.getRepresentation());

        return blackPawnsResult.toString();
    }

    public int size(){
        return blackPawns.size()+ whitePawns.size();
    }
}
