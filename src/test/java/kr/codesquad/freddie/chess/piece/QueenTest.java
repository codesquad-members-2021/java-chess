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
    void canMove() {
        checkCanMove("d4", "d5");
        checkCanMove("d4", "d6");
        checkCanMove("d4", "d3");
        checkCanMove("d4", "d2");
        checkCanMove("d4", "c4");
        checkCanMove("d4", "b4");
        checkCanMove("d4", "e4");
        checkCanMove("d4", "f4");

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
        assertThat(blackQueen.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteQueen.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void canMoveFail() {
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
        assertThat(blackQueen.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteQueen.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
