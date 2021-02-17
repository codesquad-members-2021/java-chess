package cooper.chess.piece;

import java.util.List;
import java.util.Map;

public class PawnGroup {
    public static final int WHITE_INIT_INDEX = 1;
    public static final int BLACK_INIT_INDEX = 6;

    private final Map<Color, List<Pawn>> pawnListMap;

    public PawnGroup(Map<Color, List<Pawn>> pawnListMap) {
        this.pawnListMap = pawnListMap;
    }

    public List<Pawn> getPawnList(Color color) {
        return pawnListMap.get(color);
    }
}
