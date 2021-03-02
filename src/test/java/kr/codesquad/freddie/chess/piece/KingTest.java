package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.utils.PositionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {
    private King blackKing;
    private King whiteKing;

    @BeforeEach
    void setUp() {
        blackKing = King.create(Color.BLACK);
        whiteKing = King.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackKing.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteKing.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackKing.getKind()).isEqualTo(Kind.KING);
        assertThat(whiteKing.getKind()).isEqualTo(Kind.KING);
    }

    @Test
    void getPoint() {
        assertThat(blackKing.getPoint()).isEqualTo(0);
    }

    @Test
    void getRepresentation() {
        assertThat(blackKing.getRepresentation()).isEqualTo("K");
        assertThat(whiteKing.getRepresentation()).isEqualTo("k");
    }

    @Test
    void isBlack() {
        assertThat(blackKing.isBlack()).isTrue();
        assertThat(whiteKing.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteKing.isWhite()).isTrue();
        assertThat(blackKing.isWhite()).isFalse();
    }

    @Test
    void isCanMove() {
        checkIsCanMove("b3", "b4");
        checkIsCanMove("b3", "b2");
        checkIsCanMove("b3", "c3");
        checkIsCanMove("b3", "a3");
        checkIsCanMove("b3", "c4");
        checkIsCanMove("b3", "a4");
        checkIsCanMove("b3", "c2");
        checkIsCanMove("b3", "a2");
    }

    private void checkIsCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKing.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteKing.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void isCanMoveFail() {
        checkIsCanMoveFail("b3", "b5");
        checkIsCanMoveFail("b3", "b1");
        checkIsCanMoveFail("b3", "d3");
        checkIsCanMoveFail("c3", "a3");
    }

    private void checkIsCanMoveFail(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKing.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteKing.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
