package pieces;

import chess.Board;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @BeforeAll
    void initialize() {
        Board board = new Board();
    }

    @Test
    @DisplayName("Verify pawns...")
    void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    @Test
    void createDefault() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }


    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}