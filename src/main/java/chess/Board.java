package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePawnList  = new ArrayList<>();
    private List<Piece> blackPawnList  = new ArrayList<>();

    public static final int PAWN_NUMBER = 8;

    void whitePawnAdd(Piece whitePawn) {
        whitePawnList.add(whitePawn);
    }

    void blackPawnAdd(Piece blackPawn) {
        blackPawnList.add(blackPawn);
    }

    int whitePawnSize() {
        return whitePawnList.size();
    }

    int blackPawnSize() {
        return blackPawnList.size();
    }

    Piece findWhitePawn(int index) {
        return whitePawnList.get(index);
    }

    Piece findBlackPawn(int index) {
        return blackPawnList.get(index);
    }

    void initialize() {
        for(int i = 0; i < PAWN_NUMBER ; i++){
            Piece whitePawn = new Piece(Piece.WHITE);
            whitePawnAdd(whitePawn);

            Piece blackPawn = new Piece(Piece.BLACK);
            blackPawnAdd(blackPawn);
        }
    }

    String getWhitePawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < whitePawnSize(); i++){
            sb.append(Piece.WHITE_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    String getBlackPawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < blackPawnSize(); i++){
            sb.append(Piece.BLACK_PAWN_REPRESENTATION);
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

