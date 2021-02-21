package net.Dong.chess;

public class Pawn {

    private final Color color;

    public enum Color {
        WHITE,
        BLACK;
    }


    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }


    public Pawn(String colorString) {
        if (colorString.equals("BLACK")) {
            this.color = Color.BLACK;
        } else {
            this.color = Color.WHITE;
        }
    }

    public Color getColor() {
        return this.color;
    }

    public String getSymbol() {
        if (this.color == Color.WHITE) {
            return "p";
        }
        return "P";
    }

}
