package net.honux.pieces;

import org.junit.jupiter.api.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    void createWhiteAndBlackPawns() {
        Assertions.assertAll(
                () -> verifyPawn(Pawn.WHITE_COLOR),
                () -> verifyPawn(Pawn.BLACK_COLOR));
    }

    @Test
    @DisplayName("기본 생성자로 폰을 생성할 때, 흰색 폰이 생성되어야 한다")
    void createWithDefaultPawn() {
        Pawn pawn = new Pawn();
        Assertions.assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    void createRedPawn() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Pawn redPawn = new Pawn("red");
        });
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        Assertions.assertEquals(pawn.getColor(), color);
    }

}
