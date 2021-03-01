package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public class Bishop extends Piece {
    private Bishop(Color color, Kind kind) {
        super(color, kind);
    }

    public static Bishop create(Color color) {
        return new Bishop(color, Kind.BISHOP);
    }

    @Override
    public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
        checkColorOf(sourcePosition, targetPosition, board);
        int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
        int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

        return gradientOf(fileDistance, rankDistance) == 1;
    }
}
