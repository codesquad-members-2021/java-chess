package net.kjk402.chess.pieces;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import net.kjk402.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {
    @Test
    @DisplayName("기본 생성자 실행 시 흰색폰이 생성된다.")
    void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation());
    }

    @Test
    void createPawn() {
        verifyPawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }

}
