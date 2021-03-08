package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Queen extends Piece {
    private Queen(Color color, Kind kind) {
        super(color, kind);
    }

    public static Queen create(Color color) {
        return new Queen(color, Kind.QUEEN);
    }

    @Override
    public boolean canMove(PositionCalculator positionCalculator, Piece targetPiece) {
        double gradient = Math.abs(positionCalculator.getGradient());

        return gradient == 0 || gradient == 1;
    }
}
