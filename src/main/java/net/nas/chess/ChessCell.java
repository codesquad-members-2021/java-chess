package net.nas.chess;

import net.nas.pieces.Pawn;

public class ChessCell {
    public static final char NONE_REPRESENTATION = '.';
    private Pawn occupiedBy = null;

    public Pawn getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(Pawn occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public char getRepresentation() {
        if (occupiedBy == null)
            return NONE_REPRESENTATION;
        else return occupiedBy.getRepresentation();
    }
}
