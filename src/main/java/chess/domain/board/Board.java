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

    public List<Position> getPositions() {
        return new ArrayList<>(squares.keySet());
    }

    public List<Piece> getPieces() {
        return squares.entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(toList());
    }

    // FIXME: 매우 끔찍한 함수. 미션3의 요구사항 때문에 임시로 만들었지만, 체스게임에서 사용 안할 함수이므로 삭제해야한다.
    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        int start = 48;
        int end = 56;
        getPieces().subList(start, end)
                .forEach(sb::append);
        return sb.toString();
    }

    // FIXME: 매우 끔찍한 함수. 미션3의 요구사항 때문에 임시로 만들었지만, 체스게임에서 사용 안할 함수이므로 삭제해야한다.
    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        int start = 8;
        int end = 16;
        getPieces().subList(start, end)
                .forEach(sb::append);
        return sb.toString();
    }
}
