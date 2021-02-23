package piece;

import org.junit.jupiter.api.*;
import piece.attribute.*;

import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("말이 흰색이면 true, 아니면 false를 반환해야 한다")
    void verifyIsWhite() {
        assertAll(() -> assertThat(createPiece(Color.WHITE, Type.PAWN).isWhite()).isTrue(),
                () -> assertThat(createPiece(Color.BLACK, Type.KNIGHT).isWhite()).isFalse());
    }

    @Test
    @DisplayName("말이 검은색이면 true, 아니면 false를 반환해야 한다")
    void verifyIsBlack() {
        assertAll(() -> assertThat(createPiece(Color.BLACK, Type.KING).isBlack()).isTrue(),
                () -> assertThat(createPiece(Color.WHITE, Type.QUEEN).isBlack()).isFalse());
    }

    @Test
    @DisplayName("말이 흰색이면 소문자, 검은색이면 대문자를 반환해야 한다")
    void verifyGetRepresentation() {
        assertAll(() -> assertThat(createPiece(Color.BLACK, Type.PAWN).getRepresentation()).isEqualTo('P'),
                () -> assertThat(createPiece(Color.WHITE, Type.PAWN).getRepresentation()).isEqualTo('p'),
                () -> assertThat(createPiece(Color.BLACK, Type.KNIGHT).getRepresentation()).isEqualTo('N'),
                () -> assertThat(createPiece(Color.WHITE, Type.KNIGHT).getRepresentation()).isEqualTo('n'),
                () -> assertThat(createPiece(Color.BLACK, Type.ROOK).getRepresentation()).isEqualTo('R'),
                () -> assertThat(createPiece(Color.WHITE, Type.ROOK).getRepresentation()).isEqualTo('r'),
                () -> assertThat(createPiece(Color.BLACK, Type.BISHOP).getRepresentation()).isEqualTo('B'),
                () -> assertThat(createPiece(Color.WHITE, Type.BISHOP).getRepresentation()).isEqualTo('b'),
                () -> assertThat(createPiece(Color.BLACK, Type.QUEEN).getRepresentation()).isEqualTo('Q'),
                () -> assertThat(createPiece(Color.WHITE, Type.QUEEN).getRepresentation()).isEqualTo('q'),
                () -> assertThat(createPiece(Color.BLACK, Type.KING).getRepresentation()).isEqualTo('K'),
                () -> assertThat(createPiece(Color.WHITE, Type.KING).getRepresentation()).isEqualTo('k'),
                () -> assertThat(createPiece(Color.NO_COLOR, Type.BLANK).getRepresentation()).isEqualTo('.'));
    }
}

