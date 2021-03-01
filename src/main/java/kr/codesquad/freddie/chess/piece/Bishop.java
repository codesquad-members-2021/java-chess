package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Bishop extends Piece {
    private Bishop(Color color, Kind kind) {
        super(color, kind);
    }

    public static Bishop create(Color color) {
        return new Bishop(color, Kind.BISHOP);
    }

    @Override
    public boolean isCanMove(PositionCalculator positionCalculator, Board board) {
        return Math.abs(positionCalculator.getGradient()) == 1;
    }
}
