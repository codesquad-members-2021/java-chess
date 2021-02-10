package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    void createWhitePawn() {
        Pawn pawn = new Pawn('p', Color.WHITE);
        Color expectedColor = Color.WHITE;
        Color result = pawn.getColor();
        assertThat(result).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야 한다.")
    void createBlackPawn() {
        Pawn pawn = new Pawn('p', Color.BLACK);
        Color expectedColor = Color.BLACK;
        Color result = pawn.getColor();
        assertThat(result).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("폰의 이름이 정상적으로 등록되어야 한다.")
    void setPawnName() {
        Pawn whitePawn = new Pawn('p', Color.WHITE);
        Pawn blackPawn = new Pawn('p', Color.BLACK);
        assertThat(whitePawn.getName()).isEqualTo('p');
        assertThat(blackPawn.getName()).isEqualTo('p');
    }


    @Test
    @DisplayName("Pawn 을 기본 생성자로 생성할시 하얀색으로 생성되는지 확인한다.")
    void PawnTest(){
        Pawn pawn = new Pawn();
        assertThat(Color.WHITE).isEqualTo(pawn.getColor());
    }

}
