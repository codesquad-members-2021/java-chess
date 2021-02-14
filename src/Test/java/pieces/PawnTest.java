package pieces;

import chess.Color;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다.")
    void createPawnsByColor(){
        Color white = Color.WHITE;
        Color black = Color.BLACK;

        verifyPawn(white);
        verifyPawn(black);
    }

    private void verifyPawn(Color color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본생성자로 흰색 폰을 만들어야한다.")
    void createDefaultConstructor(){
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
    }
}
