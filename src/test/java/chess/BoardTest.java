package chess;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import pieces.Pawn;

public class BoardTest {

    @Test
    @DisplayName("폰이 보드에 정상적으로 등록")
    public void create() throws Exception {
        Board board = new Board();

        Pawn whitePawn = new Pawn(Pawn.WHITE);
        board.addPawn(whitePawn);
        assertThat(board.getPawnSize()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(whitePawn);

        Pawn blackPawn = new Pawn(Pawn.BLACK);
        board.addPawn(blackPawn);
        assertThat(board.getPawnSize()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(blackPawn);
    }
}