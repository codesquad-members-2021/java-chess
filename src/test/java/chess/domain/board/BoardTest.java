package chess.domain.board;

import chess.view.BoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardTest {
    private Board board;
    private BoardView boardView;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        boardView = new BoardView(board);
    }

    @Test
    void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult())
                .isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult())
                .isEqualTo("PPPPPPPP");
    }
}
