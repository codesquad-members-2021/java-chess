package chess;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import pieces.Pawn;
import pieces.Color;

public class BoardTest {

    @Test
    public void create() throws Exception {
        Board board = new Board();
        Pawn white = new Pawn(Color.WHITE);
    }
}
