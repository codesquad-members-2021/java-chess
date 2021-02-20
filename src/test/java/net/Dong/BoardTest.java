package net.Dong;
import net.Dong.chess.Board;
import net.Dong.chess.Pawn;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import net.Dong.chess.Pawn.*;


class BoardTest {


    @Test
    void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Color.WHITE);
        board.whiteAdd(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Color.BALCK);
        board.blackAdd(black);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
    }


    @Test
    void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }
}
