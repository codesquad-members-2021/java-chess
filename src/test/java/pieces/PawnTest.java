package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("기본 생성자 호출 시 흰색 폰이 생성되어야 한다")
    public void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Piece.PAWN_WHITE.color);
        assertThat(pawn.getRepresentation()).isEqualTo(Piece.PAWN_WHITE.representation);
    }

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.PAWN_WHITE.color, Piece.PAWN_WHITE.representation);
        verifyPawn(Piece.PAWN_BLACK.color, Piece.PAWN_BLACK.representation);
    }

    public void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

}
