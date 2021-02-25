package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Color;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Piece;

import java.util.Map;

import static chess.domain.board.BoardConst.*;

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

    public double getScore(Color color) {
        double score = 0;
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            score += getColumnScore(color, columnId);
        }
        return score;
    }

    private double getColumnScore(Color color, char columnId) {
        int countOfPawns = 0;
        double scoreOfPawns = 0;
        double scoreOfRoyals = 0;
        
        for (int rowId = ROW_START; rowId <= ROW_END; rowId++) {
            Piece piece = squares.get(Position.of(columnId, rowId));
            if (!piece.isSameColor(color)) {
                continue;
            }
            if (piece instanceof Pawn) {
                scoreOfPawns += piece.getScore();
                countOfPawns++;
                continue;
            }
            scoreOfRoyals += piece.getScore();
        }
        if (countOfPawns > 1) {
            scoreOfPawns /= 2;
        }
        return scoreOfPawns + scoreOfRoyals;
    }
}
