package net.sanhee.pieces;


import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Piece {

    private final UnitColor color;
    private final char representation;

    public Piece(UnitColor color) {
        this.color = color;
        //m 생성자 매게변수를 줄이기 위해, 호출한 클래스의 이름을 활용하였습니다.
        this.representation = UnitType.getMark(this.color, this.getClass().getSimpleName());
    }

    public UnitColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isColor(UnitColor color) {
        return this.getColor().equals(color);
    }

    public boolean isBlack() {
        return this.getColor() == UnitColor.BLACK;
    }

    public boolean isWhite() {
        return this.getColor() == UnitColor.WHITE;
    }

}
