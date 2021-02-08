public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private String color;

    public Pawn(String color){
        this.color = color;
    }

    public Pawn(){
        this(WHITE);
    }

    public String getColor(){
        return this.color;
    }
}


