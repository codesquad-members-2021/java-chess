package mj.chess.pieces;

public class Piece {
    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';

    private final Color color;
    private final char representation;
    private final Type type;

    //TODO: 해쉬 이용하면 color와 key를 key로 갖고
    // representation을 value로 가질 수 있을거 같은데?
    // 그리고 그 해쉬 자료형은 getRepresnetation()에서만 이용하
    private Piece(Color color, Type type, char representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN, WHITE_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN, BLACK_REPRESENTATION);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return representation;
    }
}
