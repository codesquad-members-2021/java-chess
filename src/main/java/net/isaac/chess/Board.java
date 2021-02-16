package net.isaac.chess;

import net.isaac.pieces.Pawn;
import net.isaac.pieces.Piece;
import net.isaac.pieces.PieceColor;

public class Board {
    private static final int MAX_SIZE = 8;
    private static final int MAX_IDX = MAX_SIZE - 1;

    private Piece[][] pieces = new Piece[MAX_SIZE][MAX_SIZE];

    public void initialize(){
        for(int i = 0; i < MAX_SIZE; i++){
            add(new Pawn(PieceColor.BLACK),1,i);
            add(new Pawn(PieceColor.WHITE), MAX_IDX-1, i);
        }
    }

    public void print(){
        for(int i = 0; i < MAX_SIZE; i++) {
            for(int j = 0; j < MAX_SIZE; j++) {
                if(pieces[i][j] == null)
                    System.out.print('.');
                else
                    System.out.print(pieces[i][j].getRepresentation());
            }
            System.out.println();
        }
    }

    public boolean add(Piece piece, int rowIdx, int colIdx){
        if(!isValid(rowIdx) || !isValid(colIdx))
            return false;

        pieces[rowIdx][colIdx] = piece;
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
