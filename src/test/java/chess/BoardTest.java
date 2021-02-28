package chess;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;

import piece.Piece;
import piece.Color;
import piece.Type;
import piece.Position;

import static util.PrintUtils.showBoard;
import static piece.PieceCreator.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static util.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Verify Board initialize and toString")
    void create() {
        board.initialize();
        assertThat(board.countPieces(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.countPieces(Color.BLACK, Type.PAWN)).isEqualTo(8);

        final String BLANK_LINE = appendNewLine("........");
        assertThat(showBoard(board.getBoard()))
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        BLANK_LINE + BLANK_LINE + BLANK_LINE + BLANK_LINE +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
                );

    }

    @Test
    @DisplayName("Verify Piece by findPiece() returns exact position")
    void findPiece() {
        board.initialize();
        assertAll(
                () -> assertThat(board.findPiece("a8")).isEqualTo(createBlackRook(new Position(0, 7))),
                () -> assertThat(board.findPiece("h8")).isEqualTo(createBlackRook(new Position(7, 7))),
                () -> assertThat(board.findPiece("a1")).isEqualTo(createWhiteRook(new Position(0, 0))),
                () -> assertThat(board.findPiece("h1")).isEqualTo(createWhiteRook(new Position(7, 0)))
        );
    }

    @Test
    @DisplayName("Piece by move() should be equal to the piece by createColorPiece()")
    void move() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = createBlackRook(new Position(0, 7));
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(showBoard(board.getBoard()));
    }

    @Test
    @DisplayName("Score by calculatePoint() should be equal to the score by ")
    void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", createBlackPawn(new Position(1, 5)));
        addPiece("e6", createBlackQueen(new Position(4, 5)));
        addPiece("b8", createBlackKing(new Position(1, 7)));
        addPiece("c8", createBlackRook(new Position(2, 7)));

        addPiece("f2", createWhitePawn(new Position(5, 1)));
        addPiece("g2", createWhitePawn(new Position(7, 1)));
        addPiece("e1", createWhiteRook(new Position(4, 0)));
        addPiece("f1", createWhiteKing(new Position(5, 0)));

        assertThat(board.calculatePoint(Color.BLACK)).isCloseTo(15.0, Percentage.withPercentage(0.1));
        assertThat(board.calculatePoint(Color.WHITE)).isCloseTo(7.0, Percentage.withPercentage(0.01));

        System.out.println(showBoard(board.getBoard()));
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

}
