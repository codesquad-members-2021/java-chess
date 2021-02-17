package chess;

import pieces.Piece;
import static utills.StringUtils.*;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePieceList = new ArrayList<>();
    private List<Piece> blackPieceList = new ArrayList<>();

    private List<Piece> whitePawnList = new ArrayList<>();
    private List<Piece> blackPawnList = new ArrayList<>();

    private String nullLine = "* * * * * * * *";

    public Piece findPawn(Piece.Color color, int index){
        if(color == Piece.Color.WHITE){
            return whitePawnList.get(index);
        }else {
            return blackPawnList.get(index);
        }
    }

    public Piece findPiece(Piece.Color color, int index){
        if(color == Piece.Color.WHITE){
            return whitePieceList.get(index);
        }else {
            return blackPieceList.get(index);
        }
    }

    public int pieceCount() {
        return whitePieceList.size() + blackPieceList.size() +
                whitePawnList.size() + blackPawnList.size();
    }

    public void addPiece(Piece piece){
        if(piece.getColor() == Piece.Color.WHITE){
            if(piece.getRepresentation() == Piece.PieceRepresentation.p){
                whitePawnList.add(piece);
            }else {
                whitePieceList.add(piece);
            }
        }else{
            if(piece.getRepresentation() == Piece.PieceRepresentation.P){
                blackPawnList.add(piece);
            }else {
                blackPieceList.add(piece);
            }
        }
    }

    public void initialize(){

        for(int i = 0; i < 8; i++){
            addPiece(Piece.createWhitePawn());
            addPiece(Piece.createBlackPawn());
        }

        addPiece(Piece.createBlackRook());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackQueen());
        addPiece(Piece.createBlackKing());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackRook());

        addPiece(Piece.createWhiteRook());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteQueen());
        addPiece(Piece.createWhiteKing());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteRook());


    }

    public String getWhitePieceResult(){
        return getPieceRepresentation(whitePieceList);
    }

    public String getBlackPieceResult(){
        return getPieceRepresentation(blackPieceList);
    }

    public String getWhitePawnResult(){
        return getPieceRepresentation(whitePawnList);
    }

    public String getBlackPawnResult(){
        return getPieceRepresentation(blackPawnList);
    }

    private String getPieceRepresentation(List<Piece> pieceList) {
        StringBuilder sb = new StringBuilder();

        for (Piece piece : pieceList) {
            sb.append(piece.getRepresentation());
            sb.append(" ");
        }
        return sb.toString();
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(getBlackPawnResult());//black piece
        sb.append(appendNewLine(NEWLINE));//newLine
        sb.append(getBlackPieceResult());//black pawn
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(getWhitePieceResult());//white pawn
        sb.append(appendNewLine(NEWLINE));
        sb.append(getWhitePawnResult());//black piece

        System.out.println(sb.toString());
    }


    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlackPawnResult());//black piece
        sb.append(appendNewLine(NEWLINE));//newLine
        sb.append(getBlackPieceResult());//black pawn
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(nullLine);
        sb.append(appendNewLine(NEWLINE));
        sb.append(getWhitePieceResult());//white pawn
        sb.append(appendNewLine(NEWLINE));
        sb.append(getWhitePawnResult());//black piece

        return sb.toString();
    }
}
