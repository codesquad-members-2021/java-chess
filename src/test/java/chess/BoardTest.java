package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUP() {
        board = new Board();
    }

    @DisplayName("보드의 초기화와 출력이 올바르게 되는지 확인한다.")
    @Test
    void check() {
        board.initializeBoard();
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @DisplayName("기물의 개수를 올바르게 반환하는지 확인한다.")
    @Test
    void count() {
        board.initializeBoard();
        assertThat(board.countPiece(Piece.Color.WHITE, Piece.Type.PAWN))
                .isEqualTo(8);
        assertThat(board.countPiece(Piece.Color.BLACK, Piece.Type.ROOK))
                .isEqualTo(2);
        assertThat(board.countPiece(Piece.Color.NOCOLOR, Piece.Type.NO_PIECE))
                .isEqualTo(32);
    }
}
