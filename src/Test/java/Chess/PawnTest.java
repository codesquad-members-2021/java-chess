import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
            Pawn pawn = new Pawn("white");
            assertThat(pawn.getColor()).isEqualTo("white");
    }

//    @Test
//    public void create_기본생성자() throws Exception {
//        Pawn pawn = new Pawn();
//        assertEquals("white", pawn.getColor());
//    }
}

