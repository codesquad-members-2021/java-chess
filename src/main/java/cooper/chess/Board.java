package cooper.chess;

import cooper.chess.piece.*;
import java.util.*;

import static cooper.chess.utils.StringUtils.*;

public class Board {
    private static final int BOARD_SIZE = 8;

    private final PieceGroup pieceGroup;

    public Board() {
        this.pieceGroup = new PieceGroup();
    }

    public int pieceCount() {
        return pieceGroup.size();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        List<Piece> pieceList = pieceGroup.getPieceList();

        int pieceCount = 0;
        while(pieceCount < BOARD_SIZE * BOARD_SIZE) {
            sb.append(pieceList.get(pieceCount).getRepresentation());

            if (pieceCount % BOARD_SIZE == BOARD_SIZE - 1) {
                sb.append(NEW_LINE);
            }

            pieceCount++;
        }

        return sb.toString();
    }
}
