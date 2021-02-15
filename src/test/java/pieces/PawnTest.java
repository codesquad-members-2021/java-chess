package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {
    private Pawn pawn;
    private Pawn whitePawn;
    private Pawn blackPawn;

    @BeforeEach
    void setup() {
        pawn = new Pawn();
        whitePawn = new Pawn(Color.WHITE);
        blackPawn = new Pawn(Color.BLACK);
    }

    @Test
    @DisplayName("색상과 출력 양식에 알맞게 폰이 생성되었는지 검증한다.")
    void create() {
        assertAll(() -> verifyPawn(pawn, Color.WHITE, "p"),
                () -> verifyPawn(whitePawn, Color.WHITE, "p"),
                () -> verifyPawn(blackPawn, Color.BLACK, "P"));
    }

    void verifyPawn(Pawn pawn, Color color, String representation) {
        assertAll(() -> assertThat(pawn.getColor()).isEqualTo(color),
                () -> assertThat(pawn.getColor().getRepresentation()).isEqualTo(representation));
    }
}

