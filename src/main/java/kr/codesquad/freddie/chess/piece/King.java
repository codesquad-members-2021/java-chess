package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public class King extends Piece {
    private King(Color color, Kind kind) {
        super(color, kind);
    }

    public static King create(Color color) {
        return new King(color, Kind.KING);
    }

    @Override
    public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
        checkColorOf(sourcePosition, targetPosition, board);
        int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
        int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

        return 1 >= fileDistance && 1 >= rankDistance;
    }
}
