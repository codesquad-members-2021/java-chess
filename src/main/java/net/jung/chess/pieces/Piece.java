package net.jung.chess.pieces;

import net.jung.chess.Color;
import net.jung.chess.Name;

public class Piece {
    private Color color;
    private Name name;
    private char representation;

    private Piece(Color color, Name name ) {
        this.name = name;
        this.color = color;
        representation = color == Color.WHITE ? name.getWhiteRep() : name.getBlackRep();
    }

    public static Piece createPiece(Color color, Name name){
        return new Piece(color, name);
    }

    public Color getColor() { return color; }

    public Name getName() { return name; }

    public char getRepresentation() { return representation; }

}
