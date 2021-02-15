package net.jung.chess.pieces;

import net.jung.chess.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다.")
    void createPawnsByColor(){
        Color white = Color.WHITE;
        Color black = Color.BLACK;

        verifyPawn(white);
        verifyPawn(black);
    }

    private void verifyPawn(Color color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본생성자로 흰색 폰을 만들어야한다.")
    void createDefaultConstructor(){
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
    }

    @Test
    @DisplayName("흰색폰은 'p' 검은색 폰은 'P'의 representation을 가진다.")
    void verifyRepresentation(){
        Pawn whitePawn = new Pawn(Color.WHITE);
        assertThat(whitePawn.getRepresentation()).isEqualTo('p');

        Pawn blackPawn = new Pawn(Color.BLACK);
        assertThat(blackPawn.getRepresentation()).isEqualTo('P');
    }
}
