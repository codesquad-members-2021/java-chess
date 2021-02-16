package net.Dong.chess;

public class Pawn {


    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';


    char representation;
    private final Color color;
    public enum Color {
        WHITE,
        BLACK
    };




    public Pawn() {
        // defalut color : WHITE
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        // insert color data constructor
        this.color = color;
    }


    public Pawn(String colorString) {
        // insert String-type color constructor
        if(colorString.equals("BLACK")) {
            this.color = Color.BLACK;
        }else {
            this.color = Color.WHITE;
        }
    }
    public Pawn(Color color , char representation) {
        // insert String-type color constructor
        this.color = color;
        this.representation = representation;
    }




    public Color getColor() {
        // return current Pawn's color
        return this.color;
    }

    public char getSymbol() {
        if(this.color == Color.WHITE) {
            return 'p';
        }
        return 'P';
    }

}
