package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {
    @Test
    void createPawn() {
        checkPiece(PieceFactory.createBlackPawn(), Color.BLACK, Kind.PAWN);
        checkPiece(PieceFactory.createWhitePawn(), Color.WHITE, Kind.PAWN);
    }

    @Test
    void createKnight() {
        checkPiece(PieceFactory.createBlackKnight(), Color.BLACK, Kind.KNIGHT);
        checkPiece(PieceFactory.createWhiteKnight(), Color.WHITE, Kind.KNIGHT);
    }

    @Test
    void createRook() {
        checkPiece(PieceFactory.createBlackRook(), Color.BLACK, Kind.ROOK);
        checkPiece(PieceFactory.createWhiteRook(), Color.WHITE, Kind.ROOK);
    }

    @Test
    void createBishop() {
        checkPiece(PieceFactory.createBlackBishop(), Color.BLACK, Kind.BISHOP);
        checkPiece(PieceFactory.createWhiteBishop(), Color.WHITE, Kind.BISHOP);
    }

    @Test
    void createQueen() {
        checkPiece(PieceFactory.createBlackQueen(), Color.BLACK, Kind.QUEEN);
        checkPiece(PieceFactory.createWhiteQueen(), Color.WHITE, Kind.QUEEN);
    }

    @Test
    void createKing() {
        checkPiece(PieceFactory.createBlackKing(), Color.BLACK, Kind.KING);
        checkPiece(PieceFactory.createWhiteKing(), Color.WHITE, Kind.KING);
    }

    private void checkPiece(Piece piece, Color expectedColor, Kind expectedKind) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(expectedColor),
                () -> assertThat(piece.getKind()).isEqualTo(expectedKind)
        );
    }
}
