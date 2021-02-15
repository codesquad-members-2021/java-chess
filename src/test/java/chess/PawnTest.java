package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("색을 지정하지 않은 Pawn 클래스 생성")
    void create(){
        Pawn pawn = new Pawn();
        assertEquals("white" , pawn.getColor());
    }

    @Test
    @DisplayName("Pawn 클래스 인스턴스의 String color를 비교한다.")
    public void compare() {
        String[] colors = {"white,black"};
        for (String color : colors) {
            verifyPawn(color);
        }
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(pawn.getColor(), color);
    }
}