package pieces;

public class Pawn {

    public static Color WHITE_COLOR = Color.WHITE;
    public static Color BLACK_COLOR = Color.BLACK;

    private final Color color;

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public String getColor() {
        return color.toString();
    }

    private enum Color {
        BLACK("black"),
        WHITE("white");

        private final String color;
        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    };
}
