import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void create(){
        Pawn whitePawn = verifyPawn("white");
        Pawn blackPawn = verifyPawn("black");

        assertThat(whitePawn.getColor()).isEqualTo("white");
        assertThat(blackPawn.getColor()).isEqualTo("black");
    }
    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }

    private Pawn verifyPawn(final String color){
        return new Pawn(color);
    }
}