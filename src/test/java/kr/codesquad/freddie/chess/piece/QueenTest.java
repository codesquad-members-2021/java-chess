package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.utils.PositionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {
    private Queen blackQueen;
    private Queen whiteQueen;

    @BeforeEach
    void setUp() {
        blackQueen = Queen.create(Color.BLACK);
        whiteQueen = Queen.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackQueen.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteQueen.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackQueen.getKind()).isEqualTo(Kind.QUEEN);
        assertThat(whiteQueen.getKind()).isEqualTo(Kind.QUEEN);
    }

    @Test
    void getPoint() {
        assertThat(blackQueen.getPoint()).isEqualTo(9);
    }

    @Test
    void getRepresentation() {
        assertThat(blackQueen.getRepresentation()).isEqualTo("Q");
        assertThat(whiteQueen.getRepresentation()).isEqualTo("q");
    }

    @Test
    void isBlack() {
        assertThat(blackQueen.isBlack()).isTrue();
        assertThat(whiteQueen.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteQueen.isWhite()).isTrue();
        assertThat(blackQueen.isWhite()).isFalse();
    }

    @Test
    void isCanMove() {
        checkIsCanMove("d4", "d5");
        checkIsCanMove("d4", "d6");
        checkIsCanMove("d4", "d3");
        checkIsCanMove("d4", "d2");
        checkIsCanMove("d4", "c4");
        checkIsCanMove("d4", "b4");
        checkIsCanMove("d4", "e4");
        checkIsCanMove("d4", "f4");

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
        assertThat(blackQueen.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteQueen.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void isCanMoveFail() {
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
        assertThat(blackQueen.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteQueen.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
