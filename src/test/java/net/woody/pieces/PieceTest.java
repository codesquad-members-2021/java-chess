package net.woody.pieces;

import net.woody.chess.Representation;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("검은색 체스말들이 정상적으로 생성되어야 한다")
    void createBlackPieces() {
        assertAll(
                () -> verifyBlackPiece(Piece.createBlackPawn(), Type.PAWN),
                () -> verifyBlackPiece(Piece.createBlackKnight(), Type.KNIGHT),
                () -> verifyBlackPiece(Piece.createBlackRook(), Type.ROOK),
                () -> verifyBlackPiece(Piece.createBlackBishop(), Type.BISHOP),
                () -> verifyBlackPiece(Piece.createBlackQueen(), Type.QUEEN),
                () -> verifyBlackPiece(Piece.createBlackKing(), Type.KING)
        );
    }

    @Test
    @DisplayName("흰색 체스말들이 정상적으로 생성되어야 한다")
    void createWhitePieces() {
        assertAll(
                () -> verifyWhitePiece(Piece.createWhitePawn(), Type.PAWN),
                () -> verifyWhitePiece(Piece.createWhiteKnight(), Type.KNIGHT),
                () -> verifyWhitePiece(Piece.createWhiteRook(), Type.ROOK),
                () -> verifyWhitePiece(Piece.createWhiteBishop(), Type.BISHOP),
                () -> verifyWhitePiece(Piece.createWhiteQueen(), Type.QUEEN),
                () -> verifyWhitePiece(Piece.createWhiteKing(), Type.KING)
        );
    }

    @Test
    @DisplayName("흰색으로 생성된 폰은 흰색이어야 하고, 검은색으로 생성했을 때는 검은색이어야 한다.")
    void checkPieceColor() {
        assertAll(
                () -> assertThat(Piece.createBlackPawn().isBlack()).isTrue(),
                () -> assertThat(Piece.createWhitePawn().isWhite()).isTrue()
        );
    }

    private void verifyBlackPiece(final Piece piece, final Type type) {
        verifyPiece(piece, Color.BLACK, Character.toUpperCase(type.value()));
    }

    private void verifyWhitePiece(final Piece piece, final Type type) {
        verifyPiece(piece, Color.WHITE, Character.toLowerCase(type.value()));
    }

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

}
