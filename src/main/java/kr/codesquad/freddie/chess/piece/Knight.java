package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public class Knight extends Piece {
    private Knight(Color color, Kind kind) {
        super(color, kind);
    }

    public static Knight create(Color color) {
        return new Knight(color, Kind.KNIGHT);
    }

    @Override
    public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
        checkColorOf(sourcePosition, targetPosition, board);
        int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
        int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

        return fileDistance + rankDistance == 3 && Math.abs(fileDistance - rankDistance) == 1;
    }
}
