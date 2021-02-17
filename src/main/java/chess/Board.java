package chess;

import pieces.Piece;
import static utills.StringUtils.*;
import java.util.ArrayList;

public class Board {

    private ArrayList<Piece> whitePawnList = new ArrayList<>();
    private ArrayList<Piece> blackPawnList = new ArrayList<>();

    private String nullLine = "* * * * * * * *";

    public Piece findPawn(Piece.Color color, int index){
        if(color == Piece.Color.WHITE){
            return whitePawnList.get(index);
        }else {
            return blackPawnList.get(index);
        }

    }

    public void add(Piece pawn){
        if(pawn.getColor() == Piece.Color.WHITE){
            whitePawnList.add(pawn);

        }else{
            blackPawnList.add(pawn);
        }
    }

    public int size(){
        return whitePawnList.size() + blackPawnList.size();
    }

    public void initialize(){
        for(int i = 0; i < 8; i++){
//            whitePawnList.add(new Piece());
//            blackPawnList.add(new Piece(Piece.Color.BLACK));
        }
    }

    public String getWhitePawnResult(){
        return getPawnRepresentation(whitePawnList);
    }

    public String getBlackPawnResult(){
        return getPawnRepresentation(blackPawnList);
    }

    private String getPawnRepresentation(ArrayList<Piece> pawnList) {
        StringBuilder sb = new StringBuilder();

        for (Piece pawn : pawnList) {
            sb.append(pawn.getRepresentation());
            sb.append(" ");
        }
        return sb.toString();
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(nullLine);
        sb.append(appendNewLine());
        sb.append(getBlackPawnResult());
        sb.append(appendNewLine());
        sb.append(nullLine);
        sb.append(appendNewLine());
        sb.append(nullLine);
        sb.append(appendNewLine());
        sb.append(nullLine);
        sb.append(appendNewLine());
        sb.append(nullLine);
        sb.append(appendNewLine());
        sb.append(getWhitePawnResult());
        sb.append(appendNewLine());
        sb.append(nullLine);
        System.out.println(sb.toString());
    }
    
}
