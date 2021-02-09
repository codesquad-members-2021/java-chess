package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    private Pawn pawn;
    private Pawn whitePawn;
    private Pawn blackPawn;

    @BeforeEach
    public void setup() {
        pawn = new Pawn();
        whitePawn = new Pawn(Color.WHITE);
        blackPawn = new Pawn(Color.BLACK);
    }

    @Test
    @DisplayName("적절한 색상의 폰이 생성되었는지 검증한다.")
    public void create() {
        verifyPawn(pawn, Color.WHITE);
        verifyPawn(whitePawn, Color.WHITE);
        verifyPawn(blackPawn, Color.BLACK);
    }

    public void verifyPawn(Pawn pawn, Color color) {
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
