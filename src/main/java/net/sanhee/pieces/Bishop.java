package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Bishop extends Piece {
    public Bishop(UnitColor color) {
        super(color);
    }

    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.BISHOP == unitType && super.isColor(unitColor);
    }
}
