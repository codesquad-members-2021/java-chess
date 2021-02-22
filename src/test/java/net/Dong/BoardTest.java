package net.Dong;

import net.Dong.chess.Board;
import net.Dong.chess.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import net.Dong.chess.Pawn.*;


class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }



    @Test
    void BoardPawnCreate() {
        Board board = new Board();

        Pawn white = new Pawn(Color.WHITE);
        board.addWhite(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Color.BLACK);
        board.addWhite(black);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);

    }


    @Test
    void boardInitialize() {
        Board board = new Board();

    
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }
}

    @Test
    public void print() throws Exception {
        board.initialize();
        board.print();
    }

}

