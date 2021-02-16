package net.honux.chess.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    private  String color;


    public Pawn(){
        this(WHITE_COLOR);
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

}

