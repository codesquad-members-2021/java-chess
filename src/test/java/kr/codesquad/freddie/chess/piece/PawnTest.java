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
    void canMove() {
        checkCanMove("a2", "a3", whitePawn);
        checkCanMove("a2", "a4", whitePawn);
        checkCanMove("a7", "a6", blackPawn);
        checkCanMove("a7", "a5", blackPawn);
    }

    private void checkCanMove(String source, String target, Pawn pawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(pawn.canMove(positionCalculator, PieceFactory.createBlank())).isTrue();
    }

    @Test
    void canMoveWhenToOtherColor() {
        checkCanMoveToOtherColor("a2", "b3", whitePawn, blackPawn);
        checkCanMoveToOtherColor("d2", "c3", whitePawn, blackPawn);
        checkCanMoveToOtherColor("a7", "b6", blackPawn, whitePawn);
        checkCanMoveToOtherColor("d7", "c6", blackPawn, whitePawn);
    }

    private void checkCanMoveToOtherColor(String source, String target, Pawn sourcePawn, Pawn targetPawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(sourcePawn.canMove(positionCalculator, targetPawn)).isTrue();
    }

    @Test
    void canMoveFail() {
        checkCanMoveFail("a3", "a5", whitePawn);
        checkCanMoveFail("h1", "h3", whitePawn);
        checkCanMoveFail("a6", "a4", blackPawn);
        checkCanMoveFail("h8", "h6", blackPawn);
        checkCanMoveFail("a2", "a1", whitePawn);
        checkCanMoveFail("a7", "a8", blackPawn);
        checkCanMoveFail("a2", "a5", whitePawn);
        checkCanMoveFail("a7", "a4", blackPawn);
        checkCanMoveFail("a2", "b3", whitePawn);
        checkCanMoveFail("d2", "c3", whitePawn);
        checkCanMoveFail("a7", "b6", blackPawn);
        checkCanMoveFail("a7", "c6", blackPawn);
    }

    private void checkCanMoveFail(String source, String target, Pawn pawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(pawn.canMove(positionCalculator, PieceFactory.createBlank())).isFalse();
    }

    @Test
    void canMoveFailWhenToOtherColor() {
        checkCanMoveFailWhenToOtherColor("a2", "b4", whitePawn, blackPawn);
        checkCanMoveFailWhenToOtherColor("d2", "c4", whitePawn, blackPawn);
        checkCanMoveFailWhenToOtherColor("a7", "b5", blackPawn, whitePawn);
        checkCanMoveFailWhenToOtherColor("a7", "c5", blackPawn, whitePawn);
    }

    private void checkCanMoveFailWhenToOtherColor(String source, String target, Pawn sourcePawn, Pawn targetPawn) {
        PositionCalculator positionCalculator = new PositionCalculator(Position.of(source), Position.of(target));
        assertThat(sourcePawn.canMove(positionCalculator, targetPawn)).isFalse();
    }
}
