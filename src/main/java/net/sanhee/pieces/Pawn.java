package net.sanhee.pieces;

import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;

public class Pawn extends Piece {
    public static final int MAX_SPAWN_NUMBER = 8;

    public Pawn(UnitColor color) {
        super(color);
    }

    @Override
    public boolean isYou(UnitColor unitColor, UnitType unitType) {
        return UnitType.PAWN == unitType && super.isColor(unitColor);
    }
}
