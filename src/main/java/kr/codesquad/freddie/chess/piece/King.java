package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class King extends Piece {
    private King(Color color, Kind kind) {
        super(color, kind);
    }

    public static King create(Color color) {
        return new King(color, Kind.KING);
    }

    @Override
    public boolean isCanMove(PositionCalculator positionCalculator, Board board) {
        int fileDistance = Math.abs(positionCalculator.getFileDistance());
        int rankDistance = Math.abs(positionCalculator.getRankDistance());

        return fileDistance <= 1 && rankDistance <= 1;
    }
}
