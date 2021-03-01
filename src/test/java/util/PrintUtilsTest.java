package util;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import chess.Board;
import piece.Piece;
import piece.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static piece.PieceCreator.*;
import static util.PrintUtils.*;

class PrintUtilsTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Board board;

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
        board = new Board();
        board.initializeEmpty();
    }

    @Test
    @DisplayName("Verify showScore print total score correctly")
    public void show() {
        board.initializeEmpty();

        addPiece("f2", createWhitePawn(new Position(5, 1)));
        addPiece("g2", createWhitePawn(new Position(7, 1)));
        addPiece("e1", createWhiteRook(new Position(4, 0)));
        addPiece("f1", createWhiteKing(new Position(5, 0)));

        addPiece("b6", createBlackPawn(new Position(1, 5)));
        addPiece("e6", createBlackQueen(new Position(4, 5)));
        addPiece("b8", createBlackKing(new Position(1, 7)));
        addPiece("c8", createBlackRook(new Position(2, 7)));

        showScore(board);
        assertThat(outputStreamCaptor.toString()
                .trim()).isEqualTo("[Total score]\n" +
                "✓ White score : 7.0\n" +
                "✓ Black score : 15.0");
    }

    @Test
    @DisplayName("Verify sorting pieceList by point descending order is correctly done")
    public void sort() throws Exception {
        board.initializeEmpty();

        addPiece("f2", createWhitePawn(new Position(5, 1)));
        addPiece("g2", createWhitePawn(new Position(7, 1)));
        addPiece("e1", createWhiteRook(new Position(4, 0)));
        addPiece("f1", createWhiteKing(new Position(5, 0)));

        addPiece("b6", createBlackPawn(new Position(1, 5)));
        addPiece("e6", createBlackQueen(new Position(4, 5)));
        addPiece("b8", createBlackKing(new Position(1, 7)));
        addPiece("c8", createBlackRook(new Position(2, 7)));

        showScoreByPiece(board);
        assertThat(outputStreamCaptor.toString()
                .trim()).isEqualTo("[White Player's result]\n" +
                "ROOK : 5.0\n" +
                "PAWN : 1.0\n" +
                "PAWN : 1.0\n" +
                "KING : 0.0\n\n" +
                "[Black Player's result]\n" +
                "QUEEN : 9.0\n" +
                "ROOK : 5.0\n" +
                "PAWN : 1.0\n" +
                "KING : 0.0");
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
