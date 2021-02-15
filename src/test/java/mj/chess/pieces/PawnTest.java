package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("기본 생성자로 흰색 폰 생성")
    void createPawn() {
        verifyColorOfPawn(new Pawn(), ColorOfPiece.WHITE);
    }

    @Test
    @DisplayName("흰색 폰 생성")
    void createWhitePawn() {
        verifyColorOfPawn(new Pawn(ColorOfPiece.WHITE), ColorOfPiece.WHITE);
    }

    @Test
    @DisplayName("검은색 폰 생성")
    void createBlackPawn() {
        verifyColorOfPawn(new Pawn(ColorOfPiece.BLACK), ColorOfPiece.BLACK);
    }

    void verifyColorOfPawn(Pawn pawn, ColorOfPiece color) {
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
