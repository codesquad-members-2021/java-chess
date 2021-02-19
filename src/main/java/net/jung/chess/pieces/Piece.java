package net.jung.chess.pieces;

import net.jung.chess.Color;
import net.jung.chess.Name;

public class Piece {
    private final Color color;
    private final Name name;
    private final char representation;

    private Piece(Color color, Name name ) {
        this.name = name;
        this.color = color;
        representation = color == Color.WHITE ? name.getWhiteRep() : name.getBlackRep();
    }

    public Color getColor() { return color; }

    public Name getName() { return name; }

    public char getRepresentation() { return representation; }


    public static Piece createPiece(Color color, Name name){
        return new Piece(color, name);
    }

    public static Piece createWhitePawn(){ return new Piece(Color.WHITE, Name.PAWN); }
    public static Piece createBlackPawn(){ return new Piece(Color.BLACK, Name.PAWN); }
    public static Piece createWhiteKnight(){ return new Piece(Color.WHITE, Name.KNIGHT); }
    public static Piece createBlackKnight(){ return new Piece(Color.BLACK, Name.KNIGHT); }
    public static Piece createWhiteRook(){ return new Piece(Color.WHITE, Name.ROOK); }
    public static Piece createBlackRook(){ return new Piece(Color.BLACK, Name.ROOK); }
    public static Piece createWhiteBishop(){ return new Piece(Color.WHITE, Name.BISHOP); }
    public static Piece createBlackBishop(){ return new Piece(Color.BLACK, Name.BISHOP); }
    public static Piece createWhiteQueen(){ return new Piece(Color.WHITE, Name.QUEEN); }
    public static Piece createBlackQueen(){ return new Piece(Color.BLACK, Name.QUEEN); }
    public static Piece createWhiteKing(){ return new Piece(Color.WHITE, Name.KING); }
    public static Piece createBlackKing(){ return new Piece(Color.BLACK, Name.KING); }

    public boolean isWhite(){
        if (color == Color.WHITE)
            return true;
        return false;
    }
    public boolean isBlack() {
        if (color == Color.BLACK)
            return true;
        return false;
    }
}
