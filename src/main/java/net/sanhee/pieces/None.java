package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class None extends Piece {
    public None(UnitColor color) {
        super(color);
    }
    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.NONE == unitType && super.isColor(unitColor);
    }
}
