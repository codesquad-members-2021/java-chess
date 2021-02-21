package mj.chess.pieces;

public class Piece {

    private final Color color;
    private final Type type;
    private final String representation;
    private final RepresentationMap representationMap;

    private Piece(Color color, Type type) {
        representationMap = new RepresentationMap();

        this.color = color;
        this.type = type;
        this.representation = representationMap.getRepresentation(color, type);

        validateColor(this.color);
        validateType(this.type);
        validateRepresentation(this.representation);
    }

    private void validateColor(Color color) {
        boolean isValid = false;

        for (Color eachColor : Color.values()) {
            if (eachColor == color) {
                isValid = true;
                break;
            }
        }

        if (!isValid) throw new IllegalArgumentException("Invalid Color");
    }

    private void validateType(Type type) {
        boolean isValid = false;

        for (Type eachType : Type.values()) {
            if (eachType == type) {
                isValid = true;
                break;
            }
        }

        if (!isValid) throw new IllegalArgumentException("Invalid Type");
    }

    private void validateRepresentation(String representation) {
        boolean isValid = representationMap.containsValue(representation);

        if (!isValid) throw new IllegalArgumentException("Invalid representation");
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public String getRepresentation() {
        return representation;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }
}
