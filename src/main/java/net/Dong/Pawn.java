package net.Dong;

public class Pawn {


    public enum Color {
        WHITE,
        BALCK
    };

    Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    //public static Pawn create(String color) {
    //    return new Pawn(color);
    //}

    public Color getColor() {

        return this.color;
    }

}
