package net.noel.chess;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    public void verifyPawn(final String color){
        Pawn p = null;
        p = new Pawn(color);
        assertThat(p.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

}