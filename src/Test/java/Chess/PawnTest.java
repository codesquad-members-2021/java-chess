package Chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

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
}
