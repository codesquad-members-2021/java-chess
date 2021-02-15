package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PawnTest {
    @Test
    @DisplayName("디폴트로 흰색 폰이 생성되어야 한다.")
    public void create_default() {
        assertThat(new Pawn().getColor())
                .isEqualTo(Color.WHITE);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create_white() {
        verifyPawn(Color.WHITE);
    }

    @Test
    @DisplayName("까만 폰이 생성되어야 한다")
    public void create_black() {
        verifyPawn(Color.BLACK);
    }

    private void verifyPawn(Color color) {
        assertThat(new Pawn(color).getColor())
                .isEqualTo(color);
    }
} 
