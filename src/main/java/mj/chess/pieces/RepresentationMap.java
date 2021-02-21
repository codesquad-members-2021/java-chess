package mj.chess.pieces;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RepresentationMap {
    private final Map<String, String> representationMap = new HashMap<>();

    public RepresentationMap() {
        init();
    }

    private void init() {
        representationMap.put(Color.WHITE.name() + Type.PAWN.name(), "p");
        representationMap.put(Color.WHITE.name() + Type.ROOK.name(), "r");
        representationMap.put(Color.WHITE.name() + Type.BISHOP.name(), "b");
        representationMap.put(Color.WHITE.name() + Type.QUEEN.name(), "q");
        representationMap.put(Color.WHITE.name() + Type.KNIGHT.name(), "n");
        representationMap.put(Color.WHITE.name() + Type.KING.name(), "k");
    }

    public String getRepresentation(Color color, Type type) {
        String result = representationMap.get(Color.WHITE.name() + type.name());

        if (color == Color.WHITE) {
            return result;
        } else if (color == Color.BLACK) {
            return result.toUpperCase();
        } else {
            throw new IllegalArgumentException("color is White/Black else");
        }
    }

    public boolean containsValue(String value) {
        return representationMap.containsValue(value.toLowerCase());
    }
}
