package net.woody.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    void createWhiteAndBlackPieces() {
        assertAll(
                () -> verifyPawn(Piece.createWhitePawn(), Color.WHITE.toString(), 'p'),
                () -> verifyPawn(Piece.createBlackPawn(), Color.BLACK.toString(), 'P')
        );
    }

    @Test
    @DisplayName("흰색으로 생성된 체스말은 흰색이어야 하고, 검은색으로 생성했을 때는 검은색이어야 한다.")
    void checkThePieceColor() {
        assertAll(
                () -> assertThat(Piece.createBlackPawn().isBlack()).isTrue(),
                () -> assertThat(Piece.createWhitePawn().isWhite()).isTrue()
        );
    }

    private void verifyPawn(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor().toString()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

}
