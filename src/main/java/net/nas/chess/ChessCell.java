package net.nas.chess;

import net.nas.pieces.Pawn;

public class ChessCell {
    public static final char NONE_REPRESENTATION = '.';
    private Pawn occupiedBy = null;

    public void setOccupiedBy(Pawn piece) {
        if (occupiedBy != null)
            throw new IllegalStateException("Chess Cell is already occupied by another piece");
        occupiedBy = piece;
    }

    public char getRepresentation() {
        if (occupiedBy == null)
            return NONE_REPRESENTATION;
        else return occupiedBy.getRepresentation();
    }
}
