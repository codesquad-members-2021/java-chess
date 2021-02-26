package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class King extends Piece {
    public King(UnitColor color) {
        super(color);
    }

    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.KING == unitType && super.isColor(unitColor);
    }
}
