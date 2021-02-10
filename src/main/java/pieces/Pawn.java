package pieces;


public class Pawn {


    private enum Color { white, black }

    private final Color color;

    public Pawn(String color) {

        this.color = Color.valueOf(color);

    }

    public String getColor() {
        return color.name();
    }


}
