package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Pawn;

class BoardTest {

    Board board;

    @BeforeEach
    void testInit() {
        board = new Board();
    }

    @Test
    @DisplayName("게임 보드 생성 테스트")
    void create() throws Exception {
        addPawnToBoard(board, new Pawn(Color.WHITE), 0, 1);
        addPawnToBoard(board, new Pawn(Color.WHITE), 1, 2);
        addPawnToBoard(board, new Pawn(Color.WHITE), 2, 3);
        addPawnToBoard(board, new Pawn(Color.BLACK), 0, 4);
        addPawnToBoard(board, new Pawn(Color.BLACK), 1, 5);
        addPawnToBoard(board, new Pawn(Color.BLACK), 2, 6);
    }

    void addPawnToBoard(Board board, Pawn pawn, int index, int size) {
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(board.findPawn(pawn.getColor(), index)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("게임 보드 초기화")
   void initialize() throws Exception {
        String initBoard =
                "........" + System.lineSeparator() +
                "PPPPPPPP" + System.lineSeparator() +
                "........" + System.lineSeparator() +
                "........" + System.lineSeparator() +
                "........" + System.lineSeparator() +
                "........" + System.lineSeparator() +
                "pppppppp" + System.lineSeparator() +
                "........";

        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getPawnsResult(Color.WHITE));
        assertThat("PPPPPPPP").isEqualTo(board.getPawnsResult(Color.BLACK));
        assertThat(initBoard).isEqualTo(board.print());
        System.out.println(board.print());
    }

}
