package net.honux.chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Color.white);
        verifyPawn(Color.black);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        Assertions.assertEquals(Color.white, pawn.getColor());
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    public void create_with_unsupported_color() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Color unsupported_color = Color.getColor("red");
        });
    }

    private void verifyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}