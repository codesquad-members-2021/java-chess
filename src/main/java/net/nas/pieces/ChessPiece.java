package net.nas.pieces;

public class ChessPiece {
    private final NameOfChessPiece name;
    private final ColorOfChessPiece color;

    private ChessPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        this.name = name;
        this.color = color;
    }


    public String getRepresentation() {
        return color.getRepresentationByColor(name.getRepresentation());
    }

    public static ChessPiece createBlankPiece() {
        return createChessPiece(NameOfChessPiece.PAWN, ColorOfChessPiece.BLANK);
    }

    public static ChessPiece createChessPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        return new ChessPiece(name, color);
    }

    public boolean isBlank() {
        return color == ColorOfChessPiece.BLANK;
    }

    public boolean isBlack() {
        return color == ColorOfChessPiece.BLACK;
    }

    public boolean isWhite() {
        return color == ColorOfChessPiece.WHITE;
    }

    public static ChessPiece createWhitePawn() {
        return createChessPiece(NameOfChessPiece.PAWN, ColorOfChessPiece.WHITE);
    }

    public static ChessPiece createBlackPawn() {
        return createChessPiece(NameOfChessPiece.PAWN, ColorOfChessPiece.BLACK);
    }

    public static ChessPiece createWhiteRook() {
        return createChessPiece(NameOfChessPiece.ROOK, ColorOfChessPiece.WHITE);
    }

    public static ChessPiece createBlackRook() {
        return createChessPiece(NameOfChessPiece.ROOK, ColorOfChessPiece.BLACK);
    }

    public static ChessPiece createWhiteKnight() {
        return createChessPiece(NameOfChessPiece.KNIGHT, ColorOfChessPiece.WHITE);
    }

    public static ChessPiece createBlackKnight() {
        return createChessPiece(NameOfChessPiece.KNIGHT, ColorOfChessPiece.BLACK);
    }

    public static ChessPiece createWhiteBishop() {
        return createChessPiece(NameOfChessPiece.BISHOP, ColorOfChessPiece.WHITE);
    }

    public static ChessPiece createBlackBishop() {
        return createChessPiece(NameOfChessPiece.BISHOP, ColorOfChessPiece.BLACK);
    }

    public static ChessPiece createWhiteQueen() {
        return createChessPiece(NameOfChessPiece.QUEEN, ColorOfChessPiece.WHITE);
    }

    public static ChessPiece createBlackQueen() {
        return createChessPiece(NameOfChessPiece.QUEEN, ColorOfChessPiece.BLACK);
    }

    public static ChessPiece createWhiteKing() {
        return createChessPiece(NameOfChessPiece.KING, ColorOfChessPiece.WHITE);
    }

    public static ChessPiece createBlackKing() {
        return createChessPiece(NameOfChessPiece.KING, ColorOfChessPiece.BLACK);
    }
}
