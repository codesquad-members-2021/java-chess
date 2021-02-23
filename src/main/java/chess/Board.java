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
    public static final int ROOK_NUMBER = 2;
    public static final int KNIGHT_NUMBER = 2;
    public static final int BISHOP_NUMBER = 2;
    public static final int KING_NUMBER = 2;
    public static final int QUEEN_NUMBER = 2;
    public static final int UNIT_NUMBER_WITHOUT_PAWN = 2;

    private void whitePawnAdd(Piece whitePawn) {
        whitePawnList.add(whitePawn);
    }

    private void blackPawnAdd(Piece blackPawn) {
        blackPawnList.add(blackPawn);
    }

    public void initialize() {
        for(int i = 0; i < PAWN_NUMBER; i++){
            whitePawnAdd(Piece.getWhitePawnInstance());
            blackPawnAdd(Piece.getBlackPawnInstance());
        }

        for(int i = 0; i < UNIT_NUMBER_WITHOUT_PAWN; i++){

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

