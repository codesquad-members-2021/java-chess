package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Rook extends Piece {
    public Rook(UnitColor color) {
        super(color);
    }
    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.ROOK == unitType && super.isColor(unitColor);
    }
}
