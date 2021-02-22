package pieces;

public enum Color {
    BLACK("black"),
    WHITE("white"),
    NO_COLOR("noColor");

    private final String color;
    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
