package pieces;


import java.util.Locale;

public class Pawn {


    private enum Color {
        WHITE, BLACK;
    }

    private final Color color;

    public Pawn(String color) {

        this.color = Color.valueOf(color.toUpperCase());

    }

    public String getColor() {
      return color.name().toLowerCase();
    }


}
