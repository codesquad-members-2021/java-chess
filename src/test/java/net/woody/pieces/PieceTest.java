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
                () -> verifyBlackPiece(Piece.createBlackPawn(), Representation.PAWN),
                () -> verifyBlackPiece(Piece.createBlackKnight(), Representation.KNIGHT),
                () -> verifyBlackPiece(Piece.createBlackRook(), Representation.ROOK),
                () -> verifyBlackPiece(Piece.createBlackBishop(), Representation.BISHOP),
                () -> verifyBlackPiece(Piece.createBlackQueen(), Representation.QUEEN),
                () -> verifyBlackPiece(Piece.createBlackKing(), Representation.KING)
        );
    }

    @Test
    @DisplayName("흰색 체스말들이 정상적으로 생성되어야 한다")
    void createWhitePieces() {
        assertAll(
                () -> verifyWhitePiece(Piece.createWhitePawn(), Representation.PAWN),
                () -> verifyWhitePiece(Piece.createWhiteKnight(), Representation.KNIGHT),
                () -> verifyWhitePiece(Piece.createWhiteRook(), Representation.ROOK),
                () -> verifyWhitePiece(Piece.createWhiteBishop(), Representation.BISHOP),
                () -> verifyWhitePiece(Piece.createWhiteQueen(), Representation.QUEEN),
                () -> verifyWhitePiece(Piece.createWhiteKing(), Representation.KING)
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

    private void verifyBlackPiece(final Piece piece, final Representation representation) {
        verifyPiece(piece, Color.BLACK, Character.toUpperCase(representation.value()));
    }

    private void verifyWhitePiece(final Piece piece, final Representation representation) {
        verifyPiece(piece, Color.WHITE, Character.toLowerCase(representation.value()));
    }

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

}
