package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("색을 지정하지 않은 Pawn 클래스 생성")
    void create() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }

    @Test
    @DisplayName("Pawn 클래스 인스턴스의 String color를 비교한다.")
    void compare() {
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(pawn.getColor(), color);
    }
}