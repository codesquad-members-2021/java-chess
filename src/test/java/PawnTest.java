import net.sanhee.pieces.Pawn;
import net.sanhee.pieces.UnitColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    public void create() {
        verifyPawn(UnitColor.WHITE);
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야 한다.")
    public void create2() {
        verifyPawn(UnitColor.BLACK);
    }

    @Test
    @DisplayName("색이 없는 Pawn을 생성할 경우, white를 지정한다.")
    public void create3() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(UnitColor.WHITE);
    }

    private void verifyPawn(final UnitColor color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}