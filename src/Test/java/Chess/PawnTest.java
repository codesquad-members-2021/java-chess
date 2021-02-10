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
        verifyPawn(w);
        verifyPawn(b);

    }
    public void verifyPawn(String color){
        Pawn p = new Pawn(color);
        assertThat(p.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본생성자 사용시 흰색 폰이 생성된다.")
    public void create_기본생성자() throws Exception{
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}

