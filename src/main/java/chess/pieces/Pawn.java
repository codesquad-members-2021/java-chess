package chess.pieces;

public class Pawn {
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_REPRESENTATION = "P";
    public static final String WHITE_REPRESENTATION = "p";

    private String color;
    private String representation;

    public Pawn(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public Pawn(String color) {
        this.color = color;
    }

    Pawn() {
        this(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION); // 생성자에서 같은 클래스의 다른 생성자를 호출한다.
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
