package bibi;

public final class Pawn {
    private String color;

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
