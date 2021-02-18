package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> whitePawnList  = new ArrayList<>();
    private List<Pawn> blackPawnList  = new ArrayList<>();

    void whitePawnAdd(Pawn whitePawn) {
        whitePawnList.add(whitePawn);
    }

    void blackPawnAdd(Pawn blackPawn) {
        blackPawnList.add(blackPawn);
    }

    int whitePawnSize() {
        return whitePawnList.size();
    }

    int blackPawnSize() {
        return blackPawnList.size();
    }

    Pawn findWhitePawn(int index) {
        return whitePawnList.get(index);
    }

    Pawn findBlackPawn(int index) {
        return blackPawnList.get(index);
    }

    void initialize() {
        for(int i = 0; i < 8 ; i++){
            Pawn whitePawn = new Pawn(Pawn.WHITE,Pawn.WHITE_REPRESENTATION);
            whitePawnAdd(whitePawn);

            Pawn blackPawn = new Pawn(Pawn.BLACK,Pawn.BLACK_REPRESENTATION);
            blackPawnAdd(blackPawn);
        }
    }

    Object getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < whitePawnSize(); i++){
            sb.append(Pawn.WHITE_REPRESENTATION);
        }
        return sb.toString();
    }

    Object getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < blackPawnSize(); i++){
            sb.append(Pawn.BLACK_REPRESENTATION);
        }
        return sb.toString();
    }
}

