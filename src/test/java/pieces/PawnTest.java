package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
     void createPawn() {
        verifyPawn(Pawn.WHITE);
        verifyPawn(Pawn.BLACK);
    }
    void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
     void createBasicPawn(){
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE).isEqualTo(pawn.getColor());
//        assertThat(Pawn.WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }
}
