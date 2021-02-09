package pieces;

public class Pawn {
    private final Color color;

    public enum Color {
        WHITE("p"), BLACK("P");
        private final String representation;

        Color(String representation) {
            this.representation = representation;
        }

        public String getRepresentation() {
            return representation;
        }
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
