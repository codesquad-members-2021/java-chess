package pieces;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Color.WHITE, 'p');
        verifyPawn(Color.BLACK, 'P');
    }

    @Test
    @DisplayName("기본 생성자는 흰색 폰을 생성")
    void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo('p');
    }

    void verifyPawn(Color color, char representation) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

}
