package Pieces;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        String w = "white";
        String b = "black";
        verifyPawn(w);
        verifyPawn(b);

    }
    public void verifyPawn(String color){
        Pawn p = new Pawn(color);
        assertEquals(p.getColor(),color);
    }

    @Test
    @DisplayName("기본생성자 사용시 흰색 폰이 생성된다.")
    public void create_기본생성자() throws Exception{
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}

