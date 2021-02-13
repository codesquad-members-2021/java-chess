package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("폰 기본생성자 테스트")
    public void createBasic() throws Exception{
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR);
    }

    @Test
    @DisplayName("폰 생성자 테스트")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
    }

    public void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}