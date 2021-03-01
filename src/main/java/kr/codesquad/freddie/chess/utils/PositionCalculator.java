package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.piece.Piece;

public class PositionCalculator {
    private Position sourcePosition;
    private Position targetPosition;

    public PositionCalculator(Position sourcePosition, Position targetPosition) {
        this.sourcePosition = sourcePosition;
        this.targetPosition = targetPosition;
    }

    public int getFileDistance() {
        return distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex());
    }

    public int getRankDistance() {
        return distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex());
    }

    public Piece getSourcePieceFrom(Board board) {
        return board.findPiece(sourcePosition.toString());
    }

    public Piece getTargetPieceFrom(Board board) {
        return board.findPiece(targetPosition.toString());
    }

    public double getGradient() {
        if (getFileDistance() == 0) {
            return 0;
        }

        double fileDistance = Integer.valueOf(getFileDistance()).doubleValue();
        double rankDistance = Integer.valueOf(getRankDistance()).doubleValue();

        return rankDistance / fileDistance;
    }

    public boolean isDiagonal() {
        return 0 < getGradient();
    }

    private int distanceOf(int a, int b) {
        return a - b;
    }
}
