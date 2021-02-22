package net.woody.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    void createWhiteAndBlackPawns() {
        assertAll(
                () -> verifyPawn(Color.WHITE.toString()),
                () -> verifyPawn(Color.BLACK.toString())
        );
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    void createRedPawn() {
        assertThatThrownBy(() -> new Piece("red"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void verifyPawn(final String color) {
        Piece piece = new Piece(color);
        assertThat(piece.getColor().toString()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(Color.value(color).representation('p'));
    }

}
