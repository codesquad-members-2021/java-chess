package net.isaac.pieces;

public class Pawn extends Piece {

    public Pawn(Color color){
        super(color);
    }

    @Override
    public char getRepresentation(Color color){
        if(this.color == Color.BLACK)
            return Piece.BLACK_PAWN_REPRESENTATION;
        if(this.color == Color.WHITE)
            return Piece.WHITE_PAWN_REPRESENTATION;

        return Piece.UNKNOWN_REPRESENTATION;
    }
}
