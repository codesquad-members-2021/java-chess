package net.honux.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PawnTest {

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor())
                .isEqualTo(color);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create_white() {
        verifyPawn("white");
    }

    @Test
    @DisplayName("까만 폰이 생성되어야 한다")
    public void create_black() {
        verifyPawn("black");
    }

    @Test
    @DisplayName("존재하지 않는 색깔로는 폰을 생성할 수 없다.")
    public void create_illegal() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> verifyPawn("This is not a color."));
    }

    @Test
    @DisplayName("디폴트로 흰색 폰이 생성되어야 한다.")
    public void create_default() {
        assertThat(new Pawn().getColor())
                .isEqualTo("white");
    }
} 
