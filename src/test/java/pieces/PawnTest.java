package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
     void createPawn() {
        Pawn pawn = new Pawn(Pawn.WHITE);
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE);
        Pawn pawn2 = new Pawn(Pawn.BLACK);
        assertThat(pawn2.getColor()).isEqualTo(Pawn.BLACK);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
     void createBasicPawn(){
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE).isEqualTo(pawn.getColor());
    }
}
