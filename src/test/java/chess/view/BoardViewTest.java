package chess.view;

import chess.domain.board.Board;
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
        board = new Board();
        board.initialize();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("Board 의 positionId 들을 출력")
    void getPositionRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("a8 b8 c8 d8 e8 f8 g8 h8 ").append(NEWLINE);
        sb.append("a7 b7 c7 d7 e7 f7 g7 h7 ").append(NEWLINE);
        sb.append("a6 b6 c6 d6 e6 f6 g6 h6 ").append(NEWLINE);
        sb.append("a5 b5 c5 d5 e5 f5 g5 h5 ").append(NEWLINE);
        sb.append("a4 b4 c4 d4 e4 f4 g4 h4 ").append(NEWLINE);
        sb.append("a3 b3 c3 d3 e3 f3 g3 h3 ").append(NEWLINE);
        sb.append("a2 b2 c2 d2 e2 f2 g2 h2 ").append(NEWLINE);
        sb.append("a1 b1 c1 d1 e1 f1 g1 h1 ").append(NEWLINE);
        assertThat(boardView.getPositionRepresentation())
                .isEqualTo(sb.toString());
    }

    @Test
    @DisplayName("Board 의 Piece 위치들을 출력")
    void getPieceRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(". . . . . . . . ").append(NEWLINE);
        sb.append("P P P P P P P P ").append(NEWLINE);
        sb.append(". . . . . . . . ").append(NEWLINE);
        sb.append(". . . . . . . . ").append(NEWLINE);
        sb.append(". . . . . . . . ").append(NEWLINE);
        sb.append(". . . . . . . . ").append(NEWLINE);
        sb.append("p p p p p p p p ").append(NEWLINE);
        sb.append(". . . . . . . . ").append(NEWLINE);
        assertThat(boardView.getPieceRepresentation())
                .isEqualTo(sb.toString());
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
