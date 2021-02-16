package net.isaac.pieces;

public class Pawn extends Piece {
    public Pawn() {
        this.color = PieceColor.WHITE;
    }

    public Pawn(PieceColor color){
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public char getRepresentation(){
        if(this.color == PieceColor.BLACK)
            return 'P';
        else if(this.color == PieceColor.WHITE)
            return 'p';
        else
            return '?';
    }
}
