package net.honux.chess;

public class Pawn {
    enum Color {
        WHITE("white"),
        BLACK("black");

        private String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    private Color color;

    public Pawn(String color) {
        if (color.equals("WHITE") || color.equals("white"))
            this.color = Color.WHITE;
        else if (color.equals("BLACK") || color.equals("black"))
            this.color = Color.BLACK;
    }

    public String getColor() {
        return color.getValue();
    }

}
