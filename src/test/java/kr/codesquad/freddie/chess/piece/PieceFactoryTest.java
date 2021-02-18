package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {
    private PieceFactory blackPieceFactory;
    private PieceFactory whitePieceFactory;

    @BeforeEach
    void setUp() {
        blackPieceFactory = new PieceFactory(Color.BLACK);
        whitePieceFactory = new PieceFactory(Color.WHITE);
    }

    @Test
    void createPawn() {
        checkPiece(blackPieceFactory.createPawn(), Color.BLACK, Kind.PAWN);
        checkPiece(whitePieceFactory.createPawn(), Color.WHITE, Kind.PAWN);
    }

    @Test
    void createKnight() {
        checkPiece(blackPieceFactory.createKnight(), Color.BLACK, Kind.KNIGHT);
        checkPiece(whitePieceFactory.createKnight(), Color.WHITE, Kind.KNIGHT);
    }

    @Test
    void createRook() {
        checkPiece(blackPieceFactory.createRook(), Color.BLACK, Kind.ROOK);
        checkPiece(whitePieceFactory.createRook(), Color.WHITE, Kind.ROOK);
    }

    @Test
    void createBishop() {
        checkPiece(blackPieceFactory.createBishop(), Color.BLACK, Kind.BISHOP);
        checkPiece(whitePieceFactory.createBishop(), Color.WHITE, Kind.BISHOP);
    }

    @Test
    void createQueen() {
        checkPiece(blackPieceFactory.createQueen(), Color.BLACK, Kind.QUEEN);
        checkPiece(whitePieceFactory.createQueen(), Color.WHITE, Kind.QUEEN);
    }

    @Test
    void createKing() {
        checkPiece(blackPieceFactory.createKing(), Color.BLACK, Kind.KING);
        checkPiece(whitePieceFactory.createKing(), Color.WHITE, Kind.KING);
    }

    private void checkPiece(Piece piece, Color expectedColor, Kind expectedKind) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(expectedColor),
                () -> assertThat(piece.getKind()).isEqualTo(expectedKind)
        );
    }
}
