package Chess;

public class Pawn { 
    String color;
    public static final String W = "white";
    public static final String B = "black";

    public Pawn(String color){
        this.color = color;
    }
    public Pawn(){     this("white");}

    public String getColor(){
        return color;
    }
}
