package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.board.Position;

public class Queen extends Piece {
    private Queen(Color color, Kind kind) {
        super(color, kind);
    }

    public static Queen create(Color color) {
        return new Queen(color, Kind.QUEEN);
    }

    @Override
    public boolean isCanMove(Position sourcePosition, Position targetPosition, Board board) {
        checkColorOf(sourcePosition, targetPosition, board);
        int fileDistance = Math.abs(distanceOf(sourcePosition.getFileIndex(), targetPosition.getFileIndex()));
        int rankDistance = Math.abs(distanceOf(sourcePosition.getRankIndex(), targetPosition.getRankIndex()));

        double gradient = gradientOf(fileDistance, rankDistance);

        return gradient == 0 || gradient == 1;
    }
}
