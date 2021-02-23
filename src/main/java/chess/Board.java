package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces  = new ArrayList<>();
    private List<Piece> blackPieces  = new ArrayList<>();

    public static final int PAWN_NUMBER = 8;

    private void whitePawnAdd(Piece whitePawn) {
        whitePawns.add(whitePawn);
    }

    private void blackPawnAdd(Piece blackPawn) {
        blackPawns.add(blackPawn);
    }

    public void initialize() {
        for(int i = 0; i < PAWN_NUMBER; i++){
            whitePawnAdd(Piece.getWhitePawnInstance());
            blackPawnAdd(Piece.createBlackPawnInstance());
        }

        for(int i = 0; i < UNIT_NUMBER_WITHOUT_PAWN; i++){

        }
    }

    String bringWhitePawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < whitePawnSize(); i++){
            sb.append(Piece.WHITE_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    String bringBlackPawnsRepresentation() {
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i < blackPawnSize(); i++){
            sb.append(Piece.BLACK_PAWN_REPRESENTATION);
        }
        return sb.toString();
    }

    String getDotOnBoard(){
        return "........";
    }

    public void printBoard(){

        String board = getBoard();
        System.out.println(board);
    }

    public int pieceCount() {
        return sizeOfPieces();
    }

    private int sizeOfPieces() {
        return 0;
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder();

        sb.append(getDotOnBoard()+"\n");
        sb.append(bringWhitePawnsRepresentation()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(getDotOnBoard()+"\n");
        sb.append(bringBlackPawnsRepresentation()+"\n");
        sb.append(getDotOnBoard());

        return sb.toString();
    }
}

