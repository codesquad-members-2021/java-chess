import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
     void createPawn() {
        Pawn pawn = new Pawn(Colors.WHITE);
        assertThat(pawn.getColor()).isEqualTo(Colors.WHITE);
        Pawn pawn2 = new Pawn(Colors.BLACK);
        assertThat(pawn2.getColor()).isEqualTo(Colors.BLACK);
    }
}