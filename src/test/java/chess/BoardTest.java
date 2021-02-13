package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        verifyBoard(Pawn.Color.WHITE, 1);
        verifyBoard(Pawn.Color.BLACK, 2);
    }

    private void verifyBoard(Pawn.Color color, int index) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(index, board.size());
        assertEquals(pawn, board.findPawn(index - 1));
    }
}
