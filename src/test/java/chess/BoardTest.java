package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Pawn white, black;
    Board board;
    int size, idx;

    @BeforeEach
    public void setUP() {
        white = new Pawn(Pawn.WHITE);
        black = new Pawn(Pawn.BLACK);
        board = new Board();
        size = 1;
        idx = 0;
    }

    @Test
    public void create() throws Exception {
        check(white);
        check(black);
    }

    void check(Pawn pawn) {
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(idx));
        size++;
        idx++;
    }
}