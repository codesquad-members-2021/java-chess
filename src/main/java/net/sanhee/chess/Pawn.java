package net.sanhee.chess;


public class Pawn {
    private final String color;

    public Pawn(){
        this.color = UnitColor.WHITE.getColor();
    }

    public Pawn(String color) {

        if (color.equalsIgnoreCase(UnitColor.WHITE.getColor())
                || color.equalsIgnoreCase(UnitColor.BLACK.getColor())) {
            this.color = color;
        } else {
            this.color = UnitColor.WHITE.getColor();
        }

    }

    public String getColor() {
        return color;
    }
}
