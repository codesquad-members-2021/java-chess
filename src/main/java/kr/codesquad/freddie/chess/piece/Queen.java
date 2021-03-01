package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class Queen extends Piece {
    private Queen(Color color, Kind kind) {
        super(color, kind);
    }

    public static Queen create(Color color) {
        return new Queen(color, Kind.QUEEN);
    }

    @Override
    public boolean isCanMove(PositionCalculator positionCalculator, Board board) {
        double gradient = Math.abs(positionCalculator.getGradient());

        return gradient == 0 || gradient == 1;
    }
}
