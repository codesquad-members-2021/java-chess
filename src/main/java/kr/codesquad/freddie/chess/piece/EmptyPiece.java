package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.utils.PositionCalculator;

public class EmptyPiece extends Piece {
    private EmptyPiece(Color color, Kind kind) {
        super(color, kind);
    }

    public static EmptyPiece create() {
        return new EmptyPiece(Color.NOCOLOR, Kind.EMPTY);
    }

    @Override
    public boolean isCanMove(PositionCalculator positionCalculator, Board board) {
        return false;
    }
}
