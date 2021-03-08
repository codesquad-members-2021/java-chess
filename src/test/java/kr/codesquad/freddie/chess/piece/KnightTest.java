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
    void canMove() {
        checkCanMove("d4", "c6");
        checkCanMove("d4", "b5");
        checkCanMove("d4", "b3");
        checkCanMove("d4", "c2");
        checkCanMove("d4", "e2");
        checkCanMove("d4", "f3");
        checkCanMove("d4", "f5");
        checkCanMove("d4", "e6");
    }

    private void checkCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKnight.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteKnight.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void canMoveFail() {
        checkCanMoveFail("d4", "a4");
        checkCanMoveFail("d4", "b4");
        checkCanMoveFail("d4", "c4");
        checkCanMoveFail("d4", "e4");
        checkCanMoveFail("d4", "f4");
        checkCanMoveFail("d4", "g4");
        checkCanMoveFail("d4", "h4");
        checkCanMoveFail("d4", "d1");
        checkCanMoveFail("d4", "d2");
        checkCanMoveFail("d4", "d3");
        checkCanMoveFail("d4", "d5");
        checkCanMoveFail("d4", "d6");
        checkCanMoveFail("d4", "d7");
        checkCanMoveFail("d4", "c7");
        checkCanMoveFail("d4", "a5");
        checkCanMoveFail("d4", "a3");
        checkCanMoveFail("d4", "c1");
        checkCanMoveFail("d4", "e1");
        checkCanMoveFail("d4", "g3");
        checkCanMoveFail("d4", "g5");
        checkCanMoveFail("d4", "e7");
        checkCanMoveFail("d4", "b6");
        checkCanMoveFail("d4", "b2");
        checkCanMoveFail("d4", "f2");
        checkCanMoveFail("d4", "f6");
    }

    private void checkCanMoveFail(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKnight.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteKnight.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
