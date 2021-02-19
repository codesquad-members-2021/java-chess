package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Color;
import chess.domain.pieces.EmptyPiece;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Position, Piece> squares = new HashMap<>();

    public void initialize() {
        addRoyalRow(1, Color.WHITE);
        addPawnRow(2, Color.WHITE);
        addEmptyRow(3);
        addEmptyRow(4);
        addEmptyRow(5);
        addEmptyRow(6);
        addPawnRow(7, Color.BLACK);
        addRoyalRow(8, Color.BLACK);
    }

    private void addEmptyRow(int rowId) {
        for (char columnId = 'a'; columnId <= 'h'; columnId++) {
            squares.put(Position.of(columnId, rowId), EmptyPiece.getInstance());
        }
    }

    private void addPawnRow(int rowId, Color color) {
        for (char columnId = 'a'; columnId <= 'h'; columnId++) {
            squares.put(Position.of(columnId, rowId), new Pawn(color));
        }
    }

    // TODO: 다음 미션에서 고급 말들이 추가되도록 구현해야한다.
    private void addRoyalRow(int rowId, Color color) {
        addEmptyRow(rowId);
    }

    public Piece getPiece(Position position) {
        return squares.get(position);
    }
}
