package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePawnList  = new ArrayList<>();
    private List<Piece> blackPawnList  = new ArrayList<>();
    private List<Piece> whiteRookList  = new ArrayList<>();
    private List<Piece> blackRookList  = new ArrayList<>();
    private List<Piece> whiteKnightList  = new ArrayList<>();
    private List<Piece> blackKnightList  = new ArrayList<>();
    private List<Piece> whiteBishopList  = new ArrayList<>();
    private List<Piece> blackBishopList  = new ArrayList<>();
    private List<Piece> whiteQueenList  = new ArrayList<>();
    private List<Piece> blackQueenList  = new ArrayList<>();
    private List<Piece> whiteKingList  = new ArrayList<>();
    private List<Piece> blackKingList  = new ArrayList<>();

    public static final int PAWN_NUMBER = 8;

    public void AddPawn(Piece pawn){
        if(pawn.getColor().equals("White")){
            whitePawnAdd(pawn);
            return;
        }
        blackPawnAdd(pawn);
        return;
    }

    private void whitePawnAdd(Piece whitePawn) {
        whitePawnList.add(whitePawn);
    }

    private void blackPawnAdd(Piece blackPawn) {
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

    public void printBoard(){

        String board = getBoard();
        System.out.println(board);
    }

    public int pieceCount() {
        return 0;
    }

    public String getBoard() {
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
}

