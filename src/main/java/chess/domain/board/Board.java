package chess.domain.board;

import chess.domain.pieces.Color;
import chess.domain.pieces.EmptyPiece;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Piece;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toList;

public class Board {
    private final Map<Position, Piece> squares = new LinkedHashMap<>();

    public void initialize() {
        addRoyalRow(8, Color.BLACK);
        addPawnRow(7, Color.BLACK);
        addEmptyRow(6);
        addEmptyRow(5);
        addEmptyRow(4);
        addEmptyRow(3);
        addPawnRow(2, Color.WHITE);
        addRoyalRow(1, Color.WHITE);
    }

    private void addEmptyRow(int rowId) {
        for (int i = 'a'; i <= 'h'; i++) {
            char columnId = (char) i;
            squares.put(new Position(columnId, rowId), EmptyPiece.getInstance());
        }
    }

    private void addPawnRow(int rowId, Color color) {
        for (int i = 'a'; i <= 'h'; i++) {
            char columnId = (char) i;
            squares.put(new Position(columnId, rowId), new Pawn(color));
        }
    }

    private void addRoyalRow(int rowId, Color color) {
        addEmptyRow(rowId);
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

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        getPieces().subList(48, 56)
                .forEach(sb::append);
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        getPieces().subList(8, 16)
                .forEach(sb::append);
        return sb.toString();
    }
}
