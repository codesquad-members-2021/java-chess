package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.utils.PositionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BishopTest {
    private Bishop blackBishop;
    private Bishop whiteBishop;

    @BeforeEach
    void setUp() {
        blackBishop = Bishop.create(Color.BLACK);
        whiteBishop = Bishop.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackBishop.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteBishop.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackBishop.getKind()).isEqualTo(Kind.BISHOP);
        assertThat(whiteBishop.getKind()).isEqualTo(Kind.BISHOP);
    }

    @Test
    void getPoint() {
        assertThat(blackBishop.getPoint()).isEqualTo(3);
    }

    @Test
    void getRepresentation() {
        assertThat(blackBishop.getRepresentation()).isEqualTo("B");
        assertThat(whiteBishop.getRepresentation()).isEqualTo("b");
    }

    @Test
    void isBlack() {
        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(whiteBishop.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteBishop.isWhite()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();
    }

    @Test
    void isCanMove() {
        checkIsCanMove("d4", "e5");
        checkIsCanMove("d4", "f6");
        checkIsCanMove("d4", "e3");
        checkIsCanMove("d4", "f2");
        checkIsCanMove("d4", "c5");
        checkIsCanMove("d4", "b6");
        checkIsCanMove("d4", "c3");
        checkIsCanMove("d4", "b2");
    }

    private void checkIsCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackBishop.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteBishop.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void isCanMoveFail() {
        checkIsCanMoveFail("d4", "d5");
        checkIsCanMoveFail("d4", "d6");
        checkIsCanMoveFail("d4", "d3");
        checkIsCanMoveFail("d4", "d2");
        checkIsCanMoveFail("d4", "c4");
        checkIsCanMoveFail("d4", "b4");
        checkIsCanMoveFail("d4", "e4");
        checkIsCanMoveFail("d4", "f4");
        checkIsCanMoveFail("d4", "c6");
        checkIsCanMoveFail("d4", "b5");
        checkIsCanMoveFail("d4", "b3");
        checkIsCanMoveFail("d4", "c2");
        checkIsCanMoveFail("d4", "e2");
        checkIsCanMoveFail("d4", "f3");
        checkIsCanMoveFail("d4", "f5");
        checkIsCanMoveFail("d4", "e6");
    }

    private void checkIsCanMoveFail(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackBishop.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteBishop.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
