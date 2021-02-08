package net.nas.chess.testments;

import net.nas.chess.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("생성자에 넣은 색깔대로 폰이 생성되어야 합니다.")
    public void create(){
        final String[] testcases = {"white", "black"};
        for(String tc : testcases){
            verifyPawn(tc);
        }
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }
}
