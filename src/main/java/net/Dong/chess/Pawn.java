package net.Dong.chess;

public class Pawn {


    public enum Color {
        WHITE,
        BALCK
    };

    final Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(String colorString) {
        if(colorString.equals("BLACK")) {
            this.color = Color.BALCK;
        }else {
            this.color = Color.WHITE;
        }
    }

    //public static Pawn create(String color) {
    //    return new Pawn(color);
    //}

    public Color getColor() {

        return this.color;
    }

}
