package chess.board;

import chess.pieces.Color;
import chess.pieces.EmptyPiece;
import chess.pieces.Pawn;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toList;

public class Board {
    private final Map<Position, Piece> squares = new LinkedHashMap<>();

    public void initialize() {
        addEmptyRow(8);
        addPawnRow(7, Color.BLACK);
        for (int i = 6; i >= 3; i--) {
            addEmptyRow(i);
        }
        addPawnRow(2, Color.WHITE);
        addEmptyRow(1);
    }

    private void addEmptyRow(int rowId) {
        for (int i = 97; i <= 104; i++) {
            char columnId = (char) i;
            squares.put(new Position(columnId, rowId), EmptyPiece.getInstance());
        }
    }

    private void addPawnRow(int rowId, Color color) {
        for (int i = 97; i <= 104; i++) {
            char columnId = (char) i;
            squares.put(new Position(columnId, rowId), new Pawn(color));
        }
    }

    public List<Position> getPositions() {
        return new ArrayList<>(squares.keySet());
    }

    public List<Piece> getPieces() {
        return squares.entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(toList());
    }
}
