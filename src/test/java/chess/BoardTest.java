package chess;

import org.junit.jupiter.api.*;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Test
    @DisplayName("Verify Piece by findPiece is exact position")
    public void findPiece() {
        board.initialize();
        assertAll(
                () -> assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook(new Position(0, 7))),
                () -> assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook(new Position(7, 7))),
                () -> assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook(new Position(0, 0))),
                () -> assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook(new Position(7, 0)))
        );

    }
}
