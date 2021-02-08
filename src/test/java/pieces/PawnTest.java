package pieces;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        Pawn whitePawn = new Pawn("white");
        assertThat(whitePawn.getColor()).isEqualTo("white");

        Pawn blackPawn = new Pawn("black");
        assertThat(blackPawn.getColor()).isEqualTo("black");
    }
}
