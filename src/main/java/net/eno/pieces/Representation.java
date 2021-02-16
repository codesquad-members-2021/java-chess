package net.eno.pieces;

public enum Representation {

    WHITE('p'),
    BLACK('P');

    private final char pawn;

    Representation(char pawn) {
        this.pawn = pawn;
    }

    public char getPawn() {
        return this.pawn;
    }

}
