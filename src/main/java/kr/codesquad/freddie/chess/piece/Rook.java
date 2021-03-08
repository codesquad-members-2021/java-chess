package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Rook extends Piece {
    private Rook(Color color, Kind kind) {
        super(color, kind);
    }

    public static Rook create(Color color) {
        return new Rook(color, Kind.ROOK);
    }

    @Override
    public boolean canMove(PositionCalculator positionCalculator, Piece targetPiece) {
        return positionCalculator.getGradient() == 0;
    }
}
