package cooper.chess.piece;

import java.util.List;
import java.util.Map;

public class PieceGroup {
    public static final int PIECE_LIST_MAX = 16;

    private final Map<Color, List<Piece>> pieceListMap;

    public PieceGroup(Map<Color, List<Piece>> pieceListMap) {
        this.pieceListMap = pieceListMap;
    }

    public List<Piece> getPawnList(Color color) {
        return pieceListMap.get(color);
    }

    public int size() {
        return pieceListMap.get(Color.BLACK).size() +
                pieceListMap.get(Color.WHITE).size();
    }
}
