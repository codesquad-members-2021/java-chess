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

    @Test
    @DisplayName("흰색과 검은색 폰의 표현문자 정상출력 확인")
    void printRepresentationOfPawns() {
        verifyRepresentationOfPawn(new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION), Pawn.WHITE_REPRESENTATION);
        verifyRepresentationOfPawn(new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION), Pawn.BLACK_REPRESENTATION);
    }

    void verifyColorOfPawn(Pawn pawn, Color color) {
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    void verifyRepresentationOfPawn(Pawn pawn, final char representation) {
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
