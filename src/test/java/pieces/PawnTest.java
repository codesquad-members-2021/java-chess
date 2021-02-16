package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {

    @Test
    @DisplayName("하얀색 폰은 p를 출력해야한다.")
    void verifyWhitePawnRepresentation() {
        Pawn pawn = new Pawn(Color.WHITE);
        verifyPawn(pawn, "white", 'p');
    }

    @Test
    @DisplayName("검은색 폰은 P를 출력해야한다.")
    void verifyBlackPawnRepresentation() {
        Pawn pawn = new Pawn(Color.BLACK);
        verifyPawn(pawn, "black", 'P');
    }

    private void verifyPawn(Pawn pawn, String colorName, char representation) {
        assertAll(
                () -> assertThat(pawn.getColorName()).isEqualTo(colorName),
                () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );
    }

}
