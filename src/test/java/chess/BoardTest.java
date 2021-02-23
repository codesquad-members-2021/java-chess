package chess;

import org.junit.jupiter.api.*;

import pieces.Piece.Color;
import pieces.Piece.Type;

import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Verify Board initialize and toString")
    public void create() {
        board.initialize();
        assertThat(board.sizeofPieces(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.sizeofPieces(Color.BLACK, Type.PAWN)).isEqualTo(8);

        final String BLANK_LINE = appendNewLine("........");
        assertThat(board.toString())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        BLANK_LINE + BLANK_LINE + BLANK_LINE + BLANK_LINE +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
                );

    }
}
