package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    @DisplayName("보드를 생성하고 흰색 검은색 폰을 추가한다.")
    public void createBoardAddPawns() throws Exception{
        Board board = new Board();

        Pawn whitePawn = new Pawn(Color.WHITE);
        board.add(whitePawn);
        assertEquals(1, board.size());
        assertEquals(whitePawn, board.findPawn(0));

        Pawn blackPawn = new Pawn(Color.BLACK);
        board.add(blackPawn);
        assertEquals(2, board.size());
        assertEquals(blackPawn, board.findPawn(1));

    }

}
