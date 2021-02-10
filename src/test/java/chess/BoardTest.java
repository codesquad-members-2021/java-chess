package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import pieces.Color;
import pieces.Pawn;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void initialize() {
        board = new Board();
    }

    @Test
    @DisplayName("폰을 추가 시 전체 사이즈와 해당 인덱스의 폰이 일치해야 한다.")
    public void create() throws Exception {
        verifyPawn(Color.WHITE, 1, 0);
        verifyPawn(Color.BLACK, 2, 1);
    }

    public void verifyPawn(Color color, int size, int index) {
        Pawn pawn = new Pawn(color);
        board.addPawn(pawn);
        assertEquals(size, board.pawnSize());
        assertEquals(pawn, board.findPawn(index));
    }

}
