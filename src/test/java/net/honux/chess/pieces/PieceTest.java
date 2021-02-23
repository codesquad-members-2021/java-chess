package net.honux.chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("기본 생성자는 흰색 말과 p로 표시한다")
    void create_default_constructor() {
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(Piece.WHITE_COLOR);
        assertThat(piece.getRepresentation()).isEqualTo(Piece.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("해당 색상과 대표문자를 잘 가져오는지 확인한다")
    void check_color_representation() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}
