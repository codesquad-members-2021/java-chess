package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {

    @Test
    @DisplayName("하얀색 폰은 p를 출력해야한다.")
    void verifyWhitePawnRepresentation() {
        Pawn pawn = new Pawn(Color.WHITE);
        verifyPawn(pawn, Color.WHITE);
    }

    @Test
    @DisplayName("검은색 폰은 P를 출력해야한다.")
    void verifyBlackPawnRepresentation() {
        Pawn pawn = new Pawn(Color.BLACK);
        verifyPawn(pawn, Color.BLACK);
    }

    private void verifyPawn(Pawn pawn, Color color) {
        assertAll(
                () -> assertThat(pawn.getColorName()).isEqualTo(color.getColorName()),
                () -> assertThat(pawn.getRepresentation()).isEqualTo(color.getRepresentation())
        );
    }

}
