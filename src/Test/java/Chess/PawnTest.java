package Chess;

import org.junit.jupiter.api.*;
import org.junit.Test;      //-> 임포트했더니 테스트 에러나던 것 단번에 해결?!
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        String w = "white";
        String b = "black";
//            Pawn wPawn = new Pawn(w);
//            assertThat(wPawn.getColor()).isEqualTo(w);
//
//            Pawn bPawn = new Pawn(b);
//            assertThat(bPawn.getColor()).isEqualTo(b);
        verifyPawn(w);
        verifyPawn(b);
    }


    public void verifyPawn(String color){
        Pawn p = new Pawn(color);
        assertThat(p.getColor()).isEqualTo(color);
    }
}

