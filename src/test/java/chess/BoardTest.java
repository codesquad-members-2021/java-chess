package chess;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import pieces.Pawn;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void create() {
        Board board = new Board();

        Pawn white = new Pawn();
        board.add(white);
        assertEquals(1, board.size());

        Pawn black = new Pawn(Pawn.Color.BLACK);
        board.add(black);
        assertEquals(2, board.size());

    }

    @Test
    @DisplayName("board initialize test")
    void initialize() throws Exception {
        Board board = new Board();
        board.initialize();

        String whitePawns = "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " ";
        String blackPawns = "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " ";

        assertThat(board.getWhitePawnResult()).isEqualTo(whitePawns);
        assertThat(board.getBlackPawnResult()).isEqualTo(blackPawns);

    }

}