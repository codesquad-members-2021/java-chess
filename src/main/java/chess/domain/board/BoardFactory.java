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

    private BoardFactory() {}

    public static Board create() {
        Map<Position, Piece> squares = new HashMap<>();
        for (int rowId = ROW_START; rowId <= ROW_END; rowId++) {
            addRow(squares, rowId);
        }
        return new Board(squares);
    }

    private static void addRow(Map<Position, Piece> squares, int rowId) {
        if (rowId == 1 || rowId == 8) {
            addRoyalRow(squares, rowId);
        } else if (rowId == 2 || rowId == 7) {
            addPawnRow(squares, rowId);
        } else {
            addEmptyRow(squares, rowId);
        }
    }

    private static void addEmptyRow(Map<Position, Piece> squares, int rowId) {
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            squares.put(Position.of(columnId, rowId), EmptyPiece.getInstance());
        }
    }

    private static void addPawnRow(Map<Position, Piece> squares, int rowId) {
        Color color = getColor(rowId);
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            squares.put(Position.of(columnId, rowId), new Pawn(color));
        }
    }

    // TODO: 다음 미션에서 고급 말들이 추가되도록 구현해야한다.
    private static void addRoyalRow(Map<Position, Piece> squares, int rowId) {
        addEmptyRow(squares, rowId);
    }

    private static Color getColor(int rowId) {
        return rowId < ROW_MEDIUM ? Color.WHITE : Color.BLACK;
    }
}
