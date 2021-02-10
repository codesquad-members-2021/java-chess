package Chess;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다.")
    public void createPawnsByColor(){
        Pawn whitePawn = new Pawn ("white");
        assertThat(whitePawn.getColor()).isEqualTo("white");

        Pawn blackPawn = new Pawn("black");
        assertThat(blackPawn.getColor()).isEqualTo("black");
    }

}
