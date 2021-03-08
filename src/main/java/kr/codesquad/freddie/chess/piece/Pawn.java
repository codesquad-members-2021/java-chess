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
        if (!isAvailableMoveRange(positionCalculator)) {
            return false;
        }

        if (positionCalculator.isDiagonal()) {
            if (Math.abs(positionCalculator.getGradient()) != 1) {
                return false;
            }

            return canMoveDiagonally(targetPiece);
        }

        return isAvailableDirection(positionCalculator.getRankDistance());
    }

    private boolean isAvailableDirection(int rankDistance) {
        if (this.isWhite()) {
            return rankDistance < 0;
        }

        return 0 < rankDistance;
    }

    private boolean isAvailableMoveRange(PositionCalculator positionCalculator) {
        int rankIndex = positionCalculator.getSourcePosition().getRankIndex();

        if (rankIndex == Color.BLACK.pawnInitializationRank() || rankIndex == Color.WHITE.pawnInitializationRank()) {
            return Math.abs(positionCalculator.getRankDistance()) <= 2 && Math.abs(positionCalculator.getFileDistance()) <= 1;
        }

        return Math.abs(positionCalculator.getRankDistance()) <= 1 && Math.abs(positionCalculator.getFileDistance()) <= 1;
    }

    private boolean canMoveDiagonally(Piece targetPiece) {
        return targetPiece.getColor() != Color.NOCOLOR && this.getColor() != targetPiece.getColor();
    }
}
