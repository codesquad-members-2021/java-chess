package net.sanhee.chess;

public class Pawn {
    private final String color;

    public Pawn(String color) {

        if (color.equalsIgnoreCase("white")
                || color.equalsIgnoreCase("black")) {
            this.color = color;
        } else {
            this.color = "white";
        }

    }

    public String getColor() {
        return color;
    }
}
