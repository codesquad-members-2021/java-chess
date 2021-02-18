import net.sanhee.pieces.Pawn;
import net.sanhee.pieces.UnitColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰(p)이 생성되어야 한다.")
    void createWhitePawn() {
        verifyPawn(UnitColor.WHITE, Pawn.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("검은색 폰(P)이 생성되어야 한다.")
    void createBlackPawn() {
        verifyPawn(UnitColor.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("색이 없는 Pawn을 생성할 경우, 흰색 폰(p)을 지정한다.")
    void createDefaultPawn() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(UnitColor.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

    void verifyPawn(final UnitColor color, final char representation) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

}