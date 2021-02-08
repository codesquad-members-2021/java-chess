public class Pawn {
    private static final String WHITE = "white";
    private static final String BLACK = "black";
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

