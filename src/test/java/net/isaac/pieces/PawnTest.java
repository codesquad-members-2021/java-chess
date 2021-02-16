package net.isaac.pieces;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("폰 기본생성자 테스트")
    void basicConstructorTest() throws Exception{
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(PieceColor.WHITE);
    }

    @Test
    @DisplayName("폰 생성자 테스트")
    void colorConstructorTest() throws Exception{
        assertAll(
                ()->verifyPawn(PieceColor.WHITE),
                ()->verifyPawn(PieceColor.BLACK)
        );
    }

    void verifyPawn(PieceColor color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}