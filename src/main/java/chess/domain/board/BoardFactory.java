package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.*;

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

    private static void addRoyalRow(int rowId) {
        Color color = getColor(rowId);
        squares.put(Position.of('a', rowId), Rook.of(color));
        squares.put(Position.of('b', rowId), Knight.of(color));
        squares.put(Position.of('c', rowId), Bishop.of(color));
        squares.put(Position.of('d', rowId), Queen.of(color));
        squares.put(Position.of('e', rowId), King.of(color));
        squares.put(Position.of('f', rowId), Bishop.of(color));
        squares.put(Position.of('g', rowId), Knight.of(color));
        squares.put(Position.of('h', rowId), Rook.of(color));
    }

    private static Color getColor(int rowId) {
        return rowId < ROW_MEDIUM ? Color.WHITE : Color.BLACK;
    }
}
