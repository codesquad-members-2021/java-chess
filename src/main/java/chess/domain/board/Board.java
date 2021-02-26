package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Color;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Piece;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return squares.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isSameColor(color))
                .collect(Collectors.groupingBy(entry -> entry.getKey().getColumnId()))
                .entrySet()
                .stream().map(Map.Entry::getValue)
                .map(list -> list.stream()
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toList())
                ).map(this::getColumnScore)
                .reduce((double) 0, Double::sum);
    }

    private double getColumnScore(List<Piece> pieces) {
        double scoreOfRoyals = pieces.stream()
                .filter(piece -> !(piece instanceof Pawn))
                .map(Piece::getScore)
                .reduce((double) 0, Double::sum);

        List<Piece> pawns = pieces.stream()
                .filter(piece -> piece instanceof Pawn)
                .collect(Collectors.toList());
        double scoreOfPawns = pawns.stream()
                .map(Piece::getScore)
                .reduce((double) 0, Double::sum)
                * (pawns.size() > 1 ? 0.5 : 1);

        return scoreOfRoyals + scoreOfPawns;
    }
}
