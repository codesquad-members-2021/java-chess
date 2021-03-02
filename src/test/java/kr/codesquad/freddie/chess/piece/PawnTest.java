package kr.codesquad.freddie.chess.piece;

import kr.codesquad.freddie.chess.board.Position;
import kr.codesquad.freddie.chess.utils.PositionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {
    private Pawn blackPawn;
    private Pawn whitePawn;

    @BeforeEach
    void setUp() {
        blackPawn = Pawn.create(Color.BLACK);
        whitePawn = Pawn.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackPawn.getColor()).isEqualTo(Color.BLACK);
        assertThat(whitePawn.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackPawn.getKind()).isEqualTo(Kind.PAWN);
        assertThat(whitePawn.getKind()).isEqualTo(Kind.PAWN);
    }

    @Test
    void getPoint() {
        assertThat(blackPawn.getPoint()).isEqualTo(1);
    }

    @Test
    void getRepresentation() {
        assertThat(blackPawn.getRepresentation()).isEqualTo("P");
        assertThat(whitePawn.getRepresentation()).isEqualTo("p");
    }

    @Test
    void isBlack() {
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(whitePawn.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(blackPawn.isWhite()).isFalse();
    }

    @Test
    void isCanMove() {
        checkIsCanMove("a2", "a3", whitePawn);
        checkIsCanMove("a2", "a4", whitePawn);
        checkIsCanMove("a7", "a6", blackPawn);
        checkIsCanMove("a7", "a5", blackPawn);
    }

    private void checkIsCanMove(String source, String target, Pawn pawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(pawn.isCanMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void isCanMoveWhenToOtherColor() {
        checkIsCanMoveToOtherColor("a2", "b3", whitePawn, blackPawn);
        checkIsCanMoveToOtherColor("d2", "c3", whitePawn, blackPawn);
        checkIsCanMoveToOtherColor("a7", "b6", blackPawn, whitePawn);
        checkIsCanMoveToOtherColor("d7", "c6", blackPawn, whitePawn);
    }

    private void checkIsCanMoveToOtherColor(String source, String target, Pawn sourcePawn, Pawn targetPawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(sourcePawn.isCanMove(positionCalculator, targetPawn)).isTrue();
    }

    @Test
    void isCanMoveFail() {
        checkIsCanMoveFail("a2", "a1", whitePawn);
        checkIsCanMoveFail("a7", "a8", blackPawn);
        checkIsCanMoveFail("a2", "a5", whitePawn);
        checkIsCanMoveFail("a7", "a4", blackPawn);
        checkIsCanMoveFail("a2", "b3", whitePawn);
        checkIsCanMoveFail("d2", "c3", whitePawn);
        checkIsCanMoveFail("a7", "b6", blackPawn);
        checkIsCanMoveFail("a7", "c6", blackPawn);
    }

    private void checkIsCanMoveFail(String source, String target, Pawn pawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(pawn.isCanMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }

    @Test
    void isCanMoveFailWhenToOtherColor() {
        checkIsCanMoveFailWhenToOtherColor("a2", "b4", whitePawn, blackPawn);
        checkIsCanMoveFailWhenToOtherColor("d2", "c4", whitePawn, blackPawn);
        checkIsCanMoveFailWhenToOtherColor("a7", "b5", blackPawn, whitePawn);
        checkIsCanMoveFailWhenToOtherColor("a7", "c5", blackPawn, whitePawn);
    }

    private void checkIsCanMoveFailWhenToOtherColor(String source, String target, Pawn sourcePawn, Pawn targetPawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(sourcePawn.isCanMove(positionCalculator, targetPawn)).isFalse();
    }
}
