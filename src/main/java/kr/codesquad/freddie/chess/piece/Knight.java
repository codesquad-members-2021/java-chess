package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Knight extends Piece {
    private Knight(Color color, Kind kind) {
        super(color, kind);
    }

    public static Knight create(Color color) {
        return new Knight(color, Kind.KNIGHT);
    }

    @Override
    public boolean canMove(PositionCalculator positionCalculator, Piece targetPiece) {
        int fileDistance = Math.abs(positionCalculator.getFileDistance());
        int rankDistance = Math.abs(positionCalculator.getRankDistance());

        return fileDistance + rankDistance == 3 && Math.abs(fileDistance - rankDistance) == 1;
    }
}
