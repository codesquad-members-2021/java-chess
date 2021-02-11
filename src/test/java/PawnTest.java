import net.sanhee.chess.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    public void create(){
        verifyPawn("white");
    }
    @Test
    @DisplayName("검은색 폰이 생성되어야 한다.")
    public void create2(){
        verifyPawn("black");
    }

    @Test
    @DisplayName("약속되지 않은 문자일 경우, white를 지정한다.")
    public void checkColor(){
        Pawn pawn = new Pawn("blue");
        assertThat(pawn.getColor()).isEqualTo("white");
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}