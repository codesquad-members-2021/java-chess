package net.honux.chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    public void create_흰색폰과_검은색폰_생성() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
    }

    @Test
    @DisplayName("기본 생성자로 폰을 생성할 때, 흰색 폰이 생성되어야 한다")
    public void create_기본생성자로_폰생성() throws Exception {
        Pawn pawn = new Pawn();
        Assertions.assertEquals(Color.WHITE, pawn.getColor());
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    public void create_지원하지않는_색의_폰생성() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Color unsupported_color = Color.getColor("red");
        });
    }

    private void verifyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
