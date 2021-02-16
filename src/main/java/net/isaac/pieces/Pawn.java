package net.isaac.pieces;

public class Pawn extends Piece {
    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color){
        this.color = color;
    }


    public char getRepresentation(){
        if(this.color == Color.BLACK)
            return 'P';
        else if(this.color == Color.WHITE)
            return 'p';
        else
            return '?';
    }
}
