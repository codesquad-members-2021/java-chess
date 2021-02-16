package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    @DisplayName("하얀색 폰은 p를 출력해야한다.")
    public void createWhite() {
        verifyPawn(Color.WHITE);
    }

    @Test
    @DisplayName("검은색 폰은 p를 출력해야한다.")
    public void createBlack() {
        verifyPawn(Color.BLACK);
    }

    @Test
    @DisplayName("하얀색과 검은색 폰이 생성되어야한다.")
    public void create() {
        verifyPawn(Color.BLACK);
        verifyPawn(Color.WHITE);
    }

    public void verifyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertAll(
                () -> assertEquals(color.getColorName(), pawn.getColor(), "Color가 맞지 않습니다."),
                () -> assertEquals(color.getRepresentation(), pawn.getRepresentation(), "출력 상태가 맞지 않습니다.")
        );
    }

}
