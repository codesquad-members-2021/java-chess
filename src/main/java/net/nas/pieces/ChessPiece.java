package net.nas.pieces;

public class ChessPiece {
    private final NameOfChessPiece nameOfChessPiece;
    private final ColorOfChessPiece colorOfChessPiece;

    private ChessPiece(NameOfChessPiece nameOfChessPiece, ColorOfChessPiece colorOfChessPiece) {
        this.nameOfChessPiece = nameOfChessPiece;
        this.colorOfChessPiece = colorOfChessPiece;
    }


    public String getRepresentation() {
        return colorOfChessPiece.getRepresentationByColor(nameOfChessPiece);
    }

    public static ChessPiece createBlankPiece() {
        return createChessPiece(NameOfChessPiece.NO_PIECE, ColorOfChessPiece.BLANK);
    }

    public static ChessPiece createChessPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        return new ChessPiece(name, color);
    }

    public boolean hasSameProperty(NameOfChessPiece name, ColorOfChessPiece color) {
        return name == nameOfChessPiece && color == colorOfChessPiece;
    }

    public boolean isBlank() {
        return colorOfChessPiece == ColorOfChessPiece.BLANK;
    }

    public boolean isBlack() {
        return colorOfChessPiece == ColorOfChessPiece.BLACK;
    }

    public boolean isWhite() {
        return colorOfChessPiece == ColorOfChessPiece.WHITE;
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
