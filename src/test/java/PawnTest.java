import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {

    @Test
    public void create(){
        Pawn whitePawn = verifyPawn("white");
        Pawn blackPawn = verifyPawn("black");

        assertThat(whitePawn.getColor()).isEqualTo("white");
        assertThat(blackPawn.getColor()).isEqualTo("black");
    }

    private Pawn verifyPawn(final String color){
        return new Pawn(color);
    }
}