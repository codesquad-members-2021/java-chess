package cooper.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PawnTest {

    @Test
    @DisplayName("흰색폰이 생성되어야 한다.")
    public void create() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    @Test()
    public void checkOtherColorName() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Pawn("green"));
    }
}