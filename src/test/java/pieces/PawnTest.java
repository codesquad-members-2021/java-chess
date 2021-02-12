package pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("색 없이 Pawn을 생성하면 흰색으로 생성되어야 한다")
    public void createPawn() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    @ParameterizedTest
    @EnumSource(Color.class)
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    public void createPawnWithColor(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
