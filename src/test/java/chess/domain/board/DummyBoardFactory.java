package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.*;

import java.util.HashMap;
import java.util.Map;

import static chess.domain.board.BoardConst.*;

public class DummyBoardFactory {
    private static Map<Position, Piece> squares;

    private DummyBoardFactory() {}

    public static Board create() {
        squares = new HashMap<>();

        for (int rowId = ROW_START; rowId <= ROW_END; rowId++) {
            addEmptyRow(rowId);
        }

        squares.put(Position.of("b8"), King.ofBlack());
        squares.put(Position.of("c8"), Rook.ofBlack());
        squares.put(Position.of("a7"), Pawn.ofBlack());
        squares.put(Position.of("c7"), Pawn.ofBlack());
        squares.put(Position.of("d7"), Bishop.ofBlack());
        squares.put(Position.of("b6"), Pawn.ofBlack());
        squares.put(Position.of("e6"), Queen.ofBlack());
        squares.put(Position.of("f4"), Knight.ofWhite());
        squares.put(Position.of("g4"), Queen.ofWhite());
        squares.put(Position.of("f3"), Pawn.ofWhite());
        squares.put(Position.of("h3"), Pawn.ofWhite());
        squares.put(Position.of("f2"), Pawn.ofWhite());
        squares.put(Position.of("g2"), Pawn.ofWhite());
        squares.put(Position.of("e1"), Rook.ofWhite());
        squares.put(Position.of("f1"), King.ofWhite());
  
        return new Board(squares);
    }

    private static void addEmptyRow(int rowId) {
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            squares.put(Position.of(columnId, rowId), NoPiece.getInstance());
        }
    }
}
