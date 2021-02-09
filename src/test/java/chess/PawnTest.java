package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("Pawn 클래스 인스턴스의 String color를 비교한다.")
    public void compare(){
        Pawn pawnWhite = new Pawn("white");
        Pawn pawnBlack = new Pawn("black");
        assertEquals(pawnWhite.getColor(),"white");
        assertEquals(pawnBlack.getColor(), "black");
    }
}