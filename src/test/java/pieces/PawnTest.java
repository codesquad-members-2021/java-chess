package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검정색 폰이 생성되어야 한다")
     void createPawn() {
        Pawn whitePawn = new Pawn(Pawn.WHITE);
        assertThat(whitePawn.getColor()).isEqualTo(Pawn.WHITE);
        Pawn blackPawn= new Pawn(Pawn.BLACK);
        assertThat(blackPawn.getColor()).isEqualTo(Pawn.BLACK);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
     void createBasicPawn(){
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE).isEqualTo(pawn.getColor());
    }
}
