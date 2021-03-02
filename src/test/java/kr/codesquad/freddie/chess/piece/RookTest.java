package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.utils.PositionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {
    private Rook blackRook;
    private Rook whiteRook;

    @BeforeEach
    void setUp() {
        blackRook = Rook.create(Color.BLACK);
        whiteRook = Rook.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackRook.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteRook.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackRook.getKind()).isEqualTo(Kind.ROOK);
        assertThat(whiteRook.getKind()).isEqualTo(Kind.ROOK);
    }

    @Test
    void getPoint() {
        assertThat(blackRook.getPoint()).isEqualTo(5);
    }

    @Test
    void getRepresentation() {
        assertThat(blackRook.getRepresentation()).isEqualTo("R");
        assertThat(whiteRook.getRepresentation()).isEqualTo("r");
    }

    @Test
    void isBlack() {
        assertThat(blackRook.isBlack()).isTrue();
        assertThat(whiteRook.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteRook.isWhite()).isTrue();
        assertThat(blackRook.isWhite()).isFalse();
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
    }

    private void checkIsCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackRook.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteRook.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void isCanMoveFail() {
        checkIsCanMoveFail("d4", "e5");
        checkIsCanMoveFail("d4", "f6");
        checkIsCanMoveFail("d4", "e3");
        checkIsCanMoveFail("d4", "f2");
        checkIsCanMoveFail("d4", "c5");
        checkIsCanMoveFail("d4", "b6");
        checkIsCanMoveFail("d4", "c3");
        checkIsCanMoveFail("d4", "b2");
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
        assertThat(blackRook.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteRook.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
