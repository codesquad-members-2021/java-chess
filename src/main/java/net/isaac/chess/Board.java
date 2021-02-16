package net.isaac.chess;

import net.isaac.pieces.Pawn;
import net.isaac.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int MAX_SIZE = 8;
    private static final int MAX_IDX = MAX_SIZE - 1;

    private Piece[][] pieces = new Piece[MAX_SIZE][MAX_SIZE];
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void initialize(){
        for(int i = 0; i < MAX_SIZE; i++){
            add(new Pawn(Piece.Color.BLACK),1,i);
            add(new Pawn(Piece.Color.WHITE), MAX_IDX-1, i);
        }
    }

    public void print(){
        System.out.println(getRepresentation());
    }

    private String getRepresentation(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < MAX_SIZE; i++) {
            for(int j = 0; j < MAX_SIZE; j++) {
                if(pieces[i][j] == null)
                    builder.append('.');
                else
                    builder.append(pieces[i][j].getRepresentation());
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
    
    public String getWhitePiecesResult(){
        return this.whitePieces.stream().
                map(x->String.valueOf(x.getRepresentation())).
                reduce("",(a,b) -> a+b);
    }

    public String getBlackPiecesResult(){
        return this.blackPieces.stream().
                map(x->String.valueOf(x.getRepresentation())).
                reduce("",(a,b) -> a+b);
    }

    public boolean add(Piece piece, int rowIdx, int colIdx){
        if(!isValid(rowIdx) || !isValid(colIdx))
            return false;

        pieces[rowIdx][colIdx] = piece;

        if(piece.getColor() == Piece.Color.BLACK)
            blackPieces.add(piece);
        else if(piece.getColor() == Piece.Color.WHITE)
            whitePieces.add(piece);

        return true;
    }

    public Piece findPiece(int rowIdx, int colIdx){
        if(!isValid(rowIdx) || !isValid(colIdx))
            return null;

        return pieces[rowIdx][colIdx];
    }

    private boolean isValid(int location){
        if(location < 0 || MAX_SIZE <= location)
            return false;
        else
            return true;
    }

    public int size(){
        return MAX_SIZE*MAX_SIZE;
    }
}
