package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void create(){
        Pawn whitePawn = verifyPawn(Pawn.WHITE);
        Pawn blackPawn = verifyPawn(Pawn.BLACK);

        assertThat(whitePawn.getColor()).isEqualTo(Pawn.WHITE);
        assertThat(blackPawn.getColor()).isEqualTo(Pawn.BLACK);
    }
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor());
    }

    private Pawn verifyPawn(final String color){
        return new Pawn(color);
    }
}