package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("Pawn 클래스의 인스턴스의 String color를 비교한다.")
    public void compare(){
        Pawn pawn = new Pawn("white");
        assertEquals(pawn.getColor(),"white");
    }
}