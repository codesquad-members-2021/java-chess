package chess;

public class Pawn {
    private String color;
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public Pawn(){
        this.color = WHITE_COLOR;
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }
}