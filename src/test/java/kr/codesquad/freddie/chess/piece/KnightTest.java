package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.utils.PositionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {
    private Knight blackKnight;
    private Knight whiteKnight;

    @BeforeEach
    void setUp() {
        blackKnight = Knight.create(Color.BLACK);
        whiteKnight = Knight.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackKnight.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteKnight.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackKnight.getKind()).isEqualTo(Kind.KNIGHT);
        assertThat(whiteKnight.getKind()).isEqualTo(Kind.KNIGHT);
    }

    @Test
    void getPoint() {
        assertThat(blackKnight.getPoint()).isEqualTo(2.5);
    }

    @Test
    void getRepresentation() {
        assertThat(blackKnight.getRepresentation()).isEqualTo("N");
        assertThat(whiteKnight.getRepresentation()).isEqualTo("n");
    }

    @Test
    void isBlack() {
        assertThat(blackKnight.isBlack()).isTrue();
        assertThat(whiteKnight.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteKnight.isWhite()).isTrue();
        assertThat(blackKnight.isWhite()).isFalse();
    }

    @Test
    void isCanMove() {
        checkIsCanMove("d4", "c6");
        checkIsCanMove("d4", "b5");
        checkIsCanMove("d4", "b3");
        checkIsCanMove("d4", "c2");
        checkIsCanMove("d4", "e2");
        checkIsCanMove("d4", "f3");
        checkIsCanMove("d4", "f5");
        checkIsCanMove("d4", "e6");
    }

    private void checkIsCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKnight.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteKnight.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void isCanMoveFail() {
        checkIsCanMoveFail("d4", "a4");
        checkIsCanMoveFail("d4", "b4");
        checkIsCanMoveFail("d4", "c4");
        checkIsCanMoveFail("d4", "e4");
        checkIsCanMoveFail("d4", "f4");
        checkIsCanMoveFail("d4", "g4");
        checkIsCanMoveFail("d4", "h4");
        checkIsCanMoveFail("d4", "d1");
        checkIsCanMoveFail("d4", "d2");
        checkIsCanMoveFail("d4", "d3");
        checkIsCanMoveFail("d4", "d5");
        checkIsCanMoveFail("d4", "d6");
        checkIsCanMoveFail("d4", "d7");
        checkIsCanMoveFail("d4", "c7");
        checkIsCanMoveFail("d4", "a5");
        checkIsCanMoveFail("d4", "a3");
        checkIsCanMoveFail("d4", "c1");
        checkIsCanMoveFail("d4", "e1");
        checkIsCanMoveFail("d4", "g3");
        checkIsCanMoveFail("d4", "g5");
        checkIsCanMoveFail("d4", "e7");
        checkIsCanMoveFail("d4", "b6");
        checkIsCanMoveFail("d4", "b2");
        checkIsCanMoveFail("d4", "f2");
        checkIsCanMoveFail("d4", "f6");
    }

    private void checkIsCanMoveFail(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKnight.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteKnight.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
