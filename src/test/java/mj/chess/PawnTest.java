package mj.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("기본 생성자로 흰색 폰 생성")
    public void create_pawn() {
        verifyColorOfPawn(new Pawn(), Color.WHITE.name());
    }

    @Test
    @DisplayName("흰색 폰 생성")
    public void create_pawn_check_color_white() {
        verifyColorOfPawn(new Pawn("WHITE"), Color.WHITE.name());
    }

    @Test
    @DisplayName("검은색 폰 생성")
    public void create_pawn_check_color_balck() {
        verifyColorOfPawn(new Pawn("black"), Color.BLACK.name());
    }

    public void verifyColorOfPawn(Pawn pawn, String color){
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
