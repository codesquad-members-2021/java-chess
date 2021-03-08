package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Bishop extends Piece {
    private Bishop(Color color, Kind kind) {
        super(color, kind);
    }

    public static Bishop create(Color color) {
        return new Bishop(color, Kind.BISHOP);
    }

    @Override
    public boolean canMove(PositionCalculator positionCalculator, Piece targetPiece) {
        return Math.abs(positionCalculator.getGradient()) == 1;
    }
}
