package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public class Rook extends Piece {
    private Rook(Color color, Kind kind) {
        super(color, kind);
    }

    public static Rook create(Color color) {
        return new Rook(color, Kind.ROOK);
    }

    @Override
    public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
        checkColorOf(sourcePosition, targetPosition, board);
        int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
        int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

        return gradientOf(fileDistance, rankDistance) == 0;
    }
}
