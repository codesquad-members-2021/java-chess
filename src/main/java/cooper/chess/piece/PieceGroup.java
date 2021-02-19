package cooper.chess.piece;

import java.util.List;
import java.util.Map;

public class PieceGroup {
    public static final int WHITE_PAWN_INIT_INDEX = 1;
    public static final int BLACK_PAWN_INIT_INDEX = 6;

    private final Map<Color, List<Piece>> pawnListMap;

    public PieceGroup(Map<Color, List<Piece>> pawnListMap) {
        this.pawnListMap = pawnListMap;
    }

    public List<Piece> getPawnList(Color color) {
        return pawnListMap.get(color);
    }
}
