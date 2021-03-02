package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Pawn extends Piece {
    private Pawn(Color color, Kind kind) {
        super(color, kind);
    }

    public static Pawn create(Color color) {
        return new Pawn(color, Kind.PAWN);
    }

    @Override
    public boolean isCanMove(PositionCalculator positionCalculator, Board board) {
        Piece sourcePiece = positionCalculator.getSourcePieceFrom(board);
        Piece targetPiece = positionCalculator.getTargetPieceFrom(board);

        int fileDistance = positionCalculator.getFileDistance();
        int rankDistance = positionCalculator.getRankDistance();

        if (!isAvailableMoveRange(fileDistance, rankDistance)) {
            return false;
        }

        if (positionCalculator.isDiagonal()) {
            if (Math.abs(positionCalculator.getGradient()) != 1) {
                return false;
            }

            return isCanMoveDiagonally(sourcePiece, targetPiece);
        }

        return isAvailableDirection(sourcePiece, rankDistance);
    }

    private boolean isAvailableDirection(Piece sourcePiece, int rankDistance) {
        if (sourcePiece.isWhite()) {
            return rankDistance < 0;
        }

        return 0 < rankDistance;
    }

    private boolean isAvailableMoveRange(int fileDistance, int rankDistance) {
        return Math.abs(rankDistance) <= 2 && Math.abs(fileDistance) <= 1;
    }

    private boolean isCanMoveDiagonally(Piece sourcePiece, Piece targetPiece) {
        return targetPiece.getColor() != Color.NOCOLOR && sourcePiece.getColor() != targetPiece.getColor();
    }
}
