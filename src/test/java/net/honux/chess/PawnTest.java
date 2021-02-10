package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("폰 기본생성자 테스트")
    public void createBasic() throws Exception{
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.white);
    }

    @Test
    @DisplayName("폰 생성자 테스트")
    public void create() {
        verifyPawn(Pawn.white);
        verifyPawn(Pawn.black);
    }

    public void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}