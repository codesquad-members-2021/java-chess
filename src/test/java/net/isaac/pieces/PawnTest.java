package net.isaac.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("폰 기본생성자 테스트")
    void basicConstructorTest() throws Exception{
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Piece.Color.WHITE);
    }

    @Test
    @DisplayName("폰 생성자 테스트")
    void colorConstructorTest() throws Exception{
        assertAll(
                ()->verifyPawn(Piece.Color.WHITE),
                ()->verifyPawn(Piece.Color.BLACK)
        );
    }

    void verifyPawn(Piece.Color color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}