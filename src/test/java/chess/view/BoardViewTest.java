package chess.view;

import chess.domain.board.Board;
import chess.domain.board.BoardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.utils.StringUtils.NEWLINE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardViewTest {

    private Board board;
    private BoardView boardView;

    @BeforeEach
    void setup() {
        board = BoardFactory.create();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("main 함수에서 사용할 예쁜 모양을 출력")
    void getBoardRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("  a b c d e f g h ").append(NEWLINE);
        sb.append("8 . . . . . . . . ").append(NEWLINE);
        sb.append("7 P P P P P P P P ").append(NEWLINE);
        sb.append("6 . . . . . . . . ").append(NEWLINE);
        sb.append("5 . . . . . . . . ").append(NEWLINE);
        sb.append("4 . . . . . . . . ").append(NEWLINE);
        sb.append("3 . . . . . . . . ").append(NEWLINE);
        sb.append("2 p p p p p p p p ").append(NEWLINE);
        sb.append("1 . . . . . . . . ").append(NEWLINE);
        assertThat(boardView.getBoardRepresentation())
                .isEqualTo(sb.toString());
    }
}
