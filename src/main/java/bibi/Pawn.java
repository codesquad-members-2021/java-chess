package bibi;

public class Pawn {
    private final String color;

    Pawn(String color) {
        this.color = color;
    }

    Pawn() {
        this.color = "white";
    }

    public String getColor() {
        return color;
    }
}

