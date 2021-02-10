package mj.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰 생성")
    public void create_pawn_check_color_white() {
        verifyColorOfPawn(new Pawn(Color.WHITE), Color.WHITE);
    }

    @Test
    @DisplayName("검은색 폰 생성")
    public void create_pawn_check_color_balck() {
        verifyColorOfPawn(new Pawn(Color.BLACK), Color.BLACK);
    }

    public void verifyColorOfPawn(Pawn pawn, Color color){
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
