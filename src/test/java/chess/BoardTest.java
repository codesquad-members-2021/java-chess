package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("초기 체스판 생성")
    void create_initial_chess_board() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("인자로 받은 color와 type을 동시에 만족하는 piece의 개수를 확인한다.")
    void count_piece_with_color_and_type() {
        board.initialize();

        assertThat(board.pieceCountOf(Piece.Color.BLACK, Piece.Type.BISHOP)).isEqualTo(2);
        assertThat(board.pieceCountOf(Piece.Color.BLACK, Piece.Type.QUEEN)).isEqualTo(1);
        assertThat(board.pieceCountOf(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(8);

        assertThat(board.pieceCountOf(Piece.Color.WHITE, Piece.Type.KNIGHT)).isEqualTo(2);
        assertThat(board.pieceCountOf(Piece.Color.WHITE, Piece.Type.KING)).isEqualTo(1);
        assertThat(board.pieceCountOf(Piece.Color.WHITE, Piece.Type.PAWN)).isEqualTo(8);
    }
}
