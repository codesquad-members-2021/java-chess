package net.nas.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    @DisplayName("생성자에 넣은 색깔대로 폰이 생성되어야 합니다.")
    void testColorOfPawn() {
        for (ColorOfChessPiece tc : ColorOfChessPiece.values()) {
            verifyPawn(tc);
        }
    }

    private void verifyPawn(final ColorOfChessPiece color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본 생성자로 폰을 생성하면 하얀색이어야 합니다")
    void testDefaultConstructor() {
        assertThat(new Pawn().getColor()).isEqualTo(ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("폰은 자신의 색깔에 따라서, P 또는 p라는 출력문자를 다른 객체에게 알려줄 수 있어야 합니다")
    void testGetRepresentationChar() {
        Pawn whitePawn = new Pawn();
        Pawn blackPawn = new Pawn(ColorOfChessPiece.BLACK);
        testRepresentationCharIsCorrect(whitePawn, Pawn.WHITE_REPRESENTATION);
        testRepresentationCharIsCorrect(blackPawn, Pawn.BLACK_REPRESENTATION);
    }

    private void testRepresentationCharIsCorrect(Pawn pawn, String representationChar) {
        assertThat(pawn.getRepresentation()).isEqualTo(representationChar);
    }
}
