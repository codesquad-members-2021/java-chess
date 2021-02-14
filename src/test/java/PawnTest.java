import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        String color = "white";
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo("white");
//        assertThat(pawn2.getColor()).isEqualTo("black");
    }
}