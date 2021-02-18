package net.isaac.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("폰 생성자 테스트")
    void colorConstructorTest() throws Exception{
        assertAll(
                ()->verifyPawn(Piece.Color.WHITE),
                ()->verifyPawn(Piece.Color.BLACK)
        );
    }

    void verifyPawn(Piece.Color color){
        Pawn pawn = (Pawn)Piece.getPawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}