import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        String color = "white";
        Pawn pawn = new Pawn(color);
        verifyPawn(pawn, color);
    }
    public void verifyPawn(Pawn pawn, final String color){
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}