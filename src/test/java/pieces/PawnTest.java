package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import pieces.Pawn;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰 생성")
    void createWhitePawn() {
        verifyPawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("검은색 폰 생성")
    void createBlackPawn() {
        verifyPawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("기본생성자로 폰 생성")
    public void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

    private void verifyPawn(final String color, final String representation){
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
