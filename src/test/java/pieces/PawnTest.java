package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("기본 생성자 호출 시 흰색 폰이 생성되어야 한다")
    public void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Piece.WHITE.color);
        assertThat(pawn.getRepresentation()).isEqualTo(Piece.WHITE.pawn);
    }

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.WHITE);
        verifyPawn(Piece.BLACK);
    }

    public void verifyPawn(Piece piece) {
        Pawn pawn = new Pawn(piece);
        assertThat(pawn.getColor()).isEqualTo(piece.color);
        assertThat(pawn.getRepresentation()).isEqualTo(piece.pawn);
    }

}
