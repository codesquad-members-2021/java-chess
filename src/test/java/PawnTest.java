import net.nas.chess.ColorOfChessPiece;
import net.nas.chess.Pawn;
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

    void verifyPawn(final ColorOfChessPiece color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
