package Chess;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다.")
    public void createPawnsByColor(){
        String white = "white";
        String black = "black";

        verifyPawn(white);
        verifyPawn(black);
    }

    public void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
