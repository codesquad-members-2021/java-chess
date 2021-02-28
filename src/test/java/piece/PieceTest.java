package piece;

import org.junit.jupiter.api.*;
import piece.attribute.*;

import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {
    @Test
    @DisplayName("말이 흰색이면 true, 아니면 false를 반환")
    void verifyIsWhite() {
        assertAll(() -> assertThat(createPiece(Color.WHITE, Type.PAWN, "a2").isWhite()).isTrue(),
                () -> assertThat(createPiece(Color.BLACK, Type.KNIGHT, "b8").isWhite()).isFalse());
    }

    @Test
    @DisplayName("말이 검은색이면 true, 아니면 false를 반환")
    void verifyIsBlack() {
        assertAll(() -> assertThat(createPiece(Color.BLACK, Type.KING, "e8").isBlack()).isTrue(),
                () -> assertThat(createPiece(Color.WHITE, Type.QUEEN, "d1").isBlack()).isFalse());
    }

    @Test
    @DisplayName("말이 흰색이면 소문자, 검은색이면 대문자를 반환")
    void verifyGetRepresentation() {
        assertAll(() -> assertThat(createPiece(Color.BLACK, Type.PAWN, "a1").getRepresentation()).isEqualTo('P'),
                () -> assertThat(createPiece(Color.WHITE, Type.PAWN, "a2").getRepresentation()).isEqualTo('p'),
                () -> assertThat(createPiece(Color.BLACK, Type.KNIGHT, "a3").getRepresentation()).isEqualTo('N'),
                () -> assertThat(createPiece(Color.WHITE, Type.KNIGHT, "a4").getRepresentation()).isEqualTo('n'),
                () -> assertThat(createPiece(Color.BLACK, Type.ROOK, "a5").getRepresentation()).isEqualTo('R'),
                () -> assertThat(createPiece(Color.WHITE, Type.ROOK, "a6").getRepresentation()).isEqualTo('r'),
                () -> assertThat(createPiece(Color.BLACK, Type.BISHOP, "a7").getRepresentation()).isEqualTo('B'),
                () -> assertThat(createPiece(Color.WHITE, Type.BISHOP, "a8").getRepresentation()).isEqualTo('b'),
                () -> assertThat(createPiece(Color.BLACK, Type.QUEEN, "b1").getRepresentation()).isEqualTo('Q'),
                () -> assertThat(createPiece(Color.WHITE, Type.QUEEN, "b2").getRepresentation()).isEqualTo('q'),
                () -> assertThat(createPiece(Color.BLACK, Type.KING, "b3").getRepresentation()).isEqualTo('K'),
                () -> assertThat(createPiece(Color.WHITE, Type.KING, "b4").getRepresentation()).isEqualTo('k'),
                () -> assertThat(createPiece(Color.NO_COLOR, Type.BLANK, "b5").getRepresentation()).isEqualTo('.'));
    }
}

