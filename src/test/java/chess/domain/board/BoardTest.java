package chess.domain.board;

import chess.domain.pieces.Pawn;
import chess.domain.pieces.Rook;
import chess.view.BoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardTest {
    private Board board;
    private BoardView boardView;

    @BeforeEach
    void setup() {
        board = BoardFactory.create();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("까만 폰의 갯수를 센다.")
    void count_blackPawn() {
        assertThat(board.count(Pawn.ofBlack()))
                .isEqualTo(8);
    }

    @Test
    @DisplayName("하얀 룩의 갯수를 센다.")
    void count_whiteRook() {
        assertThat(board.count(Rook.ofWhite()))
                .isEqualTo(2);
    }
}
