package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Pawn extends Piece {
    private Pawn(Color color, Kind kind) {
        super(color, kind);
    }

    public static Pawn create(Color color) {
        return new Pawn(color, Kind.PAWN);
    }

    @Override
    public boolean canMove(PositionCalculator positionCalculator, Piece targetPiece) {
        int fileDistance = positionCalculator.getFileDistance();
        int rankDistance = positionCalculator.getRankDistance();

        if (!isAvailableMoveRange(fileDistance, rankDistance)) {
            return false;
        }

        if (positionCalculator.isDiagonal()) {
            if (Math.abs(positionCalculator.getGradient()) != 1) {
                return false;
            }

            return canMoveDiagonally(targetPiece);
        }

        return isAvailableDirection(rankDistance);
    }

    private boolean isAvailableDirection(int rankDistance) {
        if (this.isWhite()) {
            return rankDistance < 0;
        }

        return 0 < rankDistance;
    }

    private boolean isAvailableMoveRange(int fileDistance, int rankDistance) {
        return Math.abs(rankDistance) <= 2 && Math.abs(fileDistance) <= 1;
    }

    private boolean canMoveDiagonally(Piece targetPiece) {
        return targetPiece.getColor() != Color.NOCOLOR && this.getColor() != targetPiece.getColor();
    }
}
