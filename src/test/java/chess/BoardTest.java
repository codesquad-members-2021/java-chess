package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    @DisplayName("체스판 생성")
    void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);

        assertAll(
                () -> assertEquals(1, board.size()),
                () -> assertEquals(white, board.findPawn(0))
        );

        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);

        assertAll(
                () -> assertEquals(2, board.size()),
                () -> assertEquals(black, board.findPawn(1))
        );
    }
}
