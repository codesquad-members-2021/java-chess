package mj.chess.pieces;

import java.util.HashMap;
import java.util.Map;

public class RepresentationMap {
    private final Map<String, String> representationMap = new HashMap<>();

    public RepresentationMap(){
        init();
    }

    private void init(){
        representationMap.put(Color.WHITE.name() + Type.PAWN.name(), "p");
        representationMap.put(Color.BLACK.name() + Type.PAWN.name(), "P");
        representationMap.put(Color.WHITE.name() + Type.ROOK.name(), "r");
        representationMap.put(Color.BLACK.name() + Type.ROOK.name(), "R");
        representationMap.put(Color.WHITE.name() + Type.BISHOP.name(), "b");
        representationMap.put(Color.BLACK.name() + Type.BISHOP.name(), "B");
        representationMap.put(Color.WHITE.name() + Type.QUEEN.name(), "q");
        representationMap.put(Color.BLACK.name() + Type.QUEEN.name(), "Q");
        representationMap.put(Color.WHITE.name() + Type.KNIGHT.name(), "n");
        representationMap.put(Color.BLACK.name() + Type.KNIGHT.name(), "N");
        representationMap.put(Color.WHITE.name() + Type.KING.name(), "k");
        representationMap.put(Color.BLACK.name() + Type.KING.name(), "K");
    }

    public String getRepresentation(Color color, Type type){
        return representationMap.get(color.name() + type.name());
    }

    public boolean containsValue(String value){
        return representationMap.containsValue(value);
    }
}
