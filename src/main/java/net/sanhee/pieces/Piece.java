package net.sanhee.pieces;


import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Piece {

    private final UnitColor color;
    private final UnitType unitType;

    // 팩토리 메서드를 사용하기 위해, 생성자의 접근제어자를 Private 으로 하여 직접 생성을 제한하였습니다.
    private Piece(UnitColor color, UnitType unitType) {
        this.color = color;
        //m 생성자 매게변수를 줄이기 위해, 호출한 클래스의 이름을 활용하였습니다.
        this.unitType = unitType;
    }

    public UnitColor getColor() {
        return color;
    }

    public boolean isColor(UnitColor color) {
        return this.getColor() == color;
    }

    public boolean isBlack() {
        return this.getColor() == UnitColor.BLACK;
    }

    public boolean isWhite() {
        return this.getColor() == UnitColor.WHITE;
    }

    public UnitType getType() {
        return unitType;
    }

    public char getRepresentation() {
        return UnitType.getMark(this.getColor(),this.getType());
    }

    public boolean isType(UnitType type) {
        return this.getType() == type;
    }

    public static Piece createBishop(UnitColor unitColor) { //m 정적 팩토리 메서드
        return new Piece(unitColor, UnitType.BISHOP);
    }

    public static Piece createKing(UnitColor unitColor) {
        return new Piece(unitColor, UnitType.KING);
    }

    public static Piece createKnight(UnitColor unitColor) {
        return new Piece(unitColor, UnitType.KNIGHT);
    }

    public static Piece createNoPiece() {
        return new Piece(UnitColor.NOCOLOR, UnitType.NO_PIECE);
    }

    public static Piece createPawn(UnitColor unitColor) {
        return new Piece(unitColor, UnitType.PAWN);
    }

    public static Piece createQueen(UnitColor unitColor) {
        return new Piece(unitColor, UnitType.QUEEN);
    }

    public static Piece createRook(UnitColor unitColor) {
        return new Piece(unitColor, UnitType.ROOK);
    }

    public boolean isBishop(UnitColor unitColor){
        return (isType(UnitType.BISHOP) && isColor(unitColor));
    }
    public boolean isKing(UnitColor unitColor){
        return (isType(UnitType.KING) && isColor(unitColor));
    }
    public boolean isKnight(UnitColor unitColor){
        return (isType(UnitType.KNIGHT) && isColor(unitColor));
    }
    public boolean isNone(UnitColor unitColor){
        return (isType(UnitType.NO_PIECE) && isColor(unitColor));
    }
    public boolean isPawn(UnitColor unitColor){
        return (isType(UnitType.PAWN) && isColor(unitColor));
    }
    public boolean isQueen(UnitColor unitColor){
        return (isType(UnitType.QUEEN) && isColor(unitColor));
    }
    public boolean isRook(UnitColor unitColor){
        return (isType(UnitType.ROOK) && isColor(unitColor));
    }
}
