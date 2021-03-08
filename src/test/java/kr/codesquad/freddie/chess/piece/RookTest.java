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
    void canMove() {
        checkCanMove("d4", "d5");
        checkCanMove("d4", "d6");
        checkCanMove("d4", "d3");
        checkCanMove("d4", "d2");
        checkCanMove("d4", "c4");
        checkCanMove("d4", "b4");
        checkCanMove("d4", "e4");
        checkCanMove("d4", "f4");
    }

    private void checkCanMove(String source, String target) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(blackRook.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
        assertThat(whiteRook.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void canMoveFail() {
        checkCanMoveFail("d4", "e5");
        checkCanMoveFail("d4", "f6");
        checkCanMoveFail("d4", "e3");
        checkCanMoveFail("d4", "f2");
        checkCanMoveFail("d4", "c5");
        checkCanMoveFail("d4", "b6");
        checkCanMoveFail("d4", "c3");
        checkCanMoveFail("d4", "b2");
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
        assertThat(blackRook.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
        assertThat(whiteRook.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }
}
