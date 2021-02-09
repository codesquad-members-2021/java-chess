package net.Dong;

public class Pawn {


    String color = "";

    public Pawn(String ins) {
        this.color = ins;
    }

    public Pawn() {
        this.color = "white";
    }

    //public static Pawn create(String color) {
    //    return new Pawn(color);
    //}

    public String getColor() {
        return this.color;
    }

}
