package Chess;

public class Pawn {
    String color;
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public Pawn(String color){
        this.color = color;
    }
    public Pawn(){     this("white");}

    public String getColor(){
        return color;
    }
}
