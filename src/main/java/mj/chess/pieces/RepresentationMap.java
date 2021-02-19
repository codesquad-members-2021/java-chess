package mj.chess.pieces;

import java.util.HashMap;
import java.util.Map;

public class RepresentationMap {
    private final Map<String, Character> representationMap = new HashMap<>();

    public RepresentationMap(){
        init();
    }

    private void init(){
        representationMap.put(Color.WHITE.name() + Type.PAWN.name(), 'p');
        representationMap.put(Color.BLACK.name() + Type.PAWN.name(), 'P');
    }

    public char getRepresentation(Color color, Type type){
        return representationMap.get(color.name() + type.name());
    }
}
