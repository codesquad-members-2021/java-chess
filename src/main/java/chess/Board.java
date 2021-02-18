package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> whitePawnList  = new ArrayList<>();
    private List<Pawn> blackPawnList  = new ArrayList<>();

    public void whitePawnAdd(Pawn whitePawn) {
        whitePawnList.add(whitePawn);
    }

    public void blackPawnAdd(Pawn blackPawn) {
        blackPawnList.add(blackPawn);
    }

    public int whitePawnSize() {
        return whitePawnList.size();
    }

    public int blackPawnSize() {
        return blackPawnList.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawnList.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawnList.get(index);
    }

    public void initialize() {
        for(int i = 0; i < 8 ; i++){

        }
    }

    public Object getWhitePawnsResult() {
        return null;
    }

    public Object getBlackPawnsResult() {
        return null;
    }
}

