package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import pieces.Pawn;
import pieces.Color;

public class BoardTest {

    Board board;

    @BeforeEach
    void createBoard(){
        board = new Board();
    }

    @Test
    @DisplayName("보드를 생성한 후 폰 테스트 한다.")
    void createPawnAndTest() throws Exception {

        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Color.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}
