package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Pawn white, black;
    Board board;

    @BeforeEach
    public void setUP() {
        white = new Pawn(Pawn.WHITE);
        black = new Pawn(Pawn.BLACK);
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        check(white, 1, 0);
        check(black, 2 ,1);
    }

    void check(Pawn pawn, int size, int idx) {
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(idx));
    }
}