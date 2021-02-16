package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("기본 생성자로 흰색 폰 생성")
    void createPawn() {
        verifyColorOfPawn(new Pawn(), Color.WHITE);
    }

    @Test
    @DisplayName("흰색과 검은색 폰 생성")
    void createPawns() {
        for (Color color : Color.values()) verifyColorOfPawn(new Pawn(color), color);
    }

    void verifyColorOfPawn(Pawn pawn, Color color) {
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
