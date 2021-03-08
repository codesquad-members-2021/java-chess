package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.utils.PositionCalculator;

import java.util.Objects;

public class CalculablePiece extends Piece {
    private char fileIndex;

    private CalculablePiece(Color color, Kind kind, char fileIndex) {
        super(color, kind);
        this.fileIndex = fileIndex;
    }

    public static CalculablePiece create(Piece piece, char fileIndex) {
        return new CalculablePiece(piece.getColor(), piece.getKind(), fileIndex);
    }

    @Override
    public boolean canMove(PositionCalculator positionCalculator, Piece targetPiece) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CalculablePiece that = (CalculablePiece) o;
        return fileIndex == that.fileIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileIndex);
    }
}
