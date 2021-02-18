package net.sally.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import net.sally.pieces.Pawn;

import static org.assertj.core.api.Assertions.*;


public class PawnTest {

    @Test
    @DisplayName("폰 컬러의 디폴트값은 white이다")
    void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE).isEqualTo(pawn.getColor());
        assertThat(Pawn.WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }

    @Test
    @DisplayName("verfyPawn을 통해 흰색과 검은색의 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    private void verifyPawn(String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
