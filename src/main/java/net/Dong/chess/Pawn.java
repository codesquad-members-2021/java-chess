package net.Dong.chess;

public class Pawn {

    private final Color color;

    public enum Color {
        WHITE,
        BALCK
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
            this.color = Color.BALCK;
        }else {
            this.color = Color.WHITE;
        }
    }


    public Pawn(Color color, char represent) {
        this.color = color;
    }





    public Color getColor() {
        // return current Pawn's color
        return this.color;
    }

}
