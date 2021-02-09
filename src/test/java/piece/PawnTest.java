package chess;

import static org.junit.jupiter.api.Assertions.*;

import chess.Pawn;
import org.junit.jupiter.api.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    public void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }
}