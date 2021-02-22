package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> whitePawnList  = new ArrayList<>();
    private List<Pawn> blackPawnList  = new ArrayList<>();

    public static final int PAWN_NUMBER = 8;

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
        for(int i = 0; i < PAWN_NUMBER ; i++){
            Pawn whitePawn = new Pawn(Pawn.WHITE);
            whitePawnAdd(whitePawn);

            Pawn blackPawn = new Pawn(Pawn.BLACK);
            blackPawnAdd(blackPawn);
        }
    }

    String getWhitePawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < whitePawnSize(); i++){
            sb.append(Pawn.WHITE_REPRESENTATION);
        }
        return sb.toString();
    }

    String getBlackPawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < blackPawnSize(); i++){
            sb.append(Pawn.BLACK_REPRESENTATION);
        }
        return sb.toString();
    }

    String getDotOnBoard(){
        return "........";
    }

    String getBoard(){
        StringBuilder sb = new StringBuilder();

        sb.append(getDotOnBoard()+"\n");
        sb.append(getWhitePawnsRepresentation()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getBlackPawnsRepresentation()+"\n");
        sb.append(getDotOnBoard());

        return sb.toString();
    }

    public void printBoard(){

        String board = getBoard();
        System.out.println(board);
    }
}

