package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.*;

import java.util.HashMap;
import java.util.Map;

import static chess.domain.board.BoardConst.COLUMN_END;
import static chess.domain.board.BoardConst.COLUMN_START;

public class BoardFactory {
    private static Map<Position, Piece> squares;

    private BoardFactory() {}

    public static Board create() {
        squares = new HashMap<>();

        addWhiteRoyalRow(1);
        addWhitePawnRow(2);
        addEmptyRow(3);
        addEmptyRow(4);
        addEmptyRow(5);
        addEmptyRow(6);
        addBlackPawnRow(7);
        addBlackRoyalRow(8);

        return new Board(squares);
    }


    private static void addRow(int rowId, Piece piece) {
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            squares.put(Position.of(columnId, rowId), piece);
        }
    }

    private static void addEmptyRow(int rowId) {
        addRow(rowId, NoPiece.getInstance());
    }

    private static void addWhitePawnRow(int rowId) {
        addRow(rowId, Pawn.ofWhite());
    }

    private static void addBlackPawnRow(int rowId) {
        addRow(rowId, Pawn.ofBlack());
    }

    private static void addWhiteRoyalRow(int rowId) {
        squares.put(Position.of('a', rowId), Rook.ofWhite());
        squares.put(Position.of('b', rowId), Knight.ofWhite());
        squares.put(Position.of('c', rowId), Bishop.ofWhite());
        squares.put(Position.of('d', rowId), Queen.ofWhite());
        squares.put(Position.of('e', rowId), King.ofWhite());
        squares.put(Position.of('f', rowId), Bishop.ofWhite());
        squares.put(Position.of('g', rowId), Knight.ofWhite());
        squares.put(Position.of('h', rowId), Rook.ofWhite());
    }

    private static void addBlackRoyalRow(int rowId) {
        squares.put(Position.of('a', rowId), Rook.ofBlack());
        squares.put(Position.of('b', rowId), Knight.ofBlack());
        squares.put(Position.of('c', rowId), Bishop.ofBlack());
        squares.put(Position.of('d', rowId), Queen.ofBlack());
        squares.put(Position.of('e', rowId), King.ofBlack());
        squares.put(Position.of('f', rowId), Bishop.ofBlack());
        squares.put(Position.of('g', rowId), Knight.ofBlack());
        squares.put(Position.of('h', rowId), Rook.ofBlack());
    }
}
