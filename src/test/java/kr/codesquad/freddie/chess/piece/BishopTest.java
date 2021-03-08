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
    void canMove() {
        checkCanMove("d4", "e5");
        checkCanMove("d4", "f6");
        checkCanMove("d4", "e3");
        checkCanMove("d4", "f2");
        checkCanMove("d4", "c5");
        checkCanMove("d4", "b6");
        checkCanMove("d4", "c3");
        checkCanMove("d4", "b2");
    }

    private void checkCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackBishop.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteBishop.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void canMoveFail() {
        checkCanMoveFail("d4", "d5");
        checkCanMoveFail("d4", "d6");
        checkCanMoveFail("d4", "d3");
        checkCanMoveFail("d4", "d2");
        checkCanMoveFail("d4", "c4");
        checkCanMoveFail("d4", "b4");
        checkCanMoveFail("d4", "e4");
        checkCanMoveFail("d4", "f4");
        checkCanMoveFail("d4", "c6");
        checkCanMoveFail("d4", "b5");
        checkCanMoveFail("d4", "b3");
        checkCanMoveFail("d4", "c2");
        checkCanMoveFail("d4", "e2");
        checkCanMoveFail("d4", "f3");
        checkCanMoveFail("d4", "f5");
        checkCanMoveFail("d4", "e6");
    }

    private void checkCanMoveFail(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackBishop.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteBishop.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
