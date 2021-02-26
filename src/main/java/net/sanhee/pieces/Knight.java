package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Knight extends Piece {
    public Knight(UnitColor color) {
        super(color);
    }
    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.KNIGHT == unitType && super.isColor(unitColor);
    }
}
