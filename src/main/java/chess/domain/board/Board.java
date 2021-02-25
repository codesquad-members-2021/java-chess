package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Piece;

import java.util.Map;

public class Board {
    private final Map<Position, Piece> squares;

    Board(Map<Position, Piece> squares) {
        this.squares = squares;
    }

    public Piece getPiece(Position position) {
        return squares.get(position);
    }

    public long count(Piece piece) {
        return squares.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(piece::equals)
                .count();
    }

    public void put(Position position, Piece piece) {
        squares.put(position, piece);
    }
}
