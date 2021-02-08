package pieces;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        final String white = "white";
        final String black = "black";
        verifyPawn(white);
        verifyPawn(black);
    }

    @Test
    @DisplayName("기본 생성자는 흰색 폰을 생성")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo("white");
    }

    public void verifyPawn(String color) {
        Pawn pawn = new Pawn(Pawn.Color.valueOf(color.toUpperCase()));
        assertThat(pawn.getColor()).isEqualTo(color.toLowerCase());
    }


}
