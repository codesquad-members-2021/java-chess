package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

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
        for(int i =0; i<8; i++){
            whitePawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            blackPawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    public int size(){
        return blackPawns.size()+ whitePawns.size();
    }
}
