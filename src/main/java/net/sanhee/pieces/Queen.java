package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Queen extends Piece {
    public Queen(UnitColor color) {
        super(color);
    }
    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.QUEEN == unitType && super.isColor(unitColor);
    }
}
