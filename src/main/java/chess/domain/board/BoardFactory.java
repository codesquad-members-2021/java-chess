package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Color;
import chess.domain.pieces.EmptyPiece;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

import static chess.domain.board.BoardConst.*;

public class BoardFactory {
    private static final int ROW_MEDIUM = (ROW_START + ROW_END) / 2;

    private static Map<Position, Piece> squares;

    private BoardFactory() {}

    public static Board create() {
        squares = new HashMap<>();
        for (int rowId = ROW_START; rowId <= ROW_END; rowId++) {
            addConditionalRow(rowId);
        }
        return new Board(squares);
    }

    private static void addConditionalRow(int rowId) {
        if (rowId == 1 || rowId == 8) {
            addRoyalRow(rowId);
        } else if (rowId == 2 || rowId == 7) {
            addPawnRow(rowId);
        } else {
            addEmptyRow(rowId);
        }
    }

    private static void addRow(int rowId, Piece piece) {
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            squares.put(Position.of(columnId, rowId), piece);
        }
    }

    private static void addEmptyRow(int rowId) {
        addRow(rowId, EmptyPiece.getInstance());
    }

    private static void addPawnRow(int rowId) {
        Color color = getColor(rowId);
        addRow(rowId, Pawn.of(color));
    }

    // TODO: 다음 미션에서 고급 말들이 추가되도록 구현해야한다.
    private static void addRoyalRow(int rowId) {
        addEmptyRow(rowId);
    }

    private static Color getColor(int rowId) {
        return rowId < ROW_MEDIUM ? Color.WHITE : Color.BLACK;
    }
}
