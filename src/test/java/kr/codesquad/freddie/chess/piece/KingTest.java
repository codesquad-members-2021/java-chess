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
    void canMove() {
        checkCanMove("b3", "b4");
        checkCanMove("b3", "b2");
        checkCanMove("b3", "c3");
        checkCanMove("b3", "a3");
        checkCanMove("b3", "c4");
        checkCanMove("b3", "a4");
        checkCanMove("b3", "c2");
        checkCanMove("b3", "a2");
    }

    private void checkCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKing.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteKing.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void canMoveFail() {
        checkCanMoveFail("b3", "b5");
        checkCanMoveFail("b3", "b1");
        checkCanMoveFail("b3", "d3");
        checkCanMoveFail("c3", "a3");
    }

    private void checkCanMoveFail(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackKing.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteKing.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
