package chess;

import org.junit.jupiter.api.*;
import piece.Piece;
import piece.attribute.Color;
import piece.attribute.Type;

import static util.StringUtil.*;
import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판이 제대로 초기화되었는지 검증한다")
    void verifyInitialize() {
        board.initialize();
        String result = new StringBuilder()
                .append("R N B Q K B N R   8").append(NEWLINE)
                .append("P P P P P P P P   7").append(NEWLINE)
                .append(". . . . . . . .   6").append(NEWLINE)
                .append(". . . . . . . .   5").append(NEWLINE)
                .append(". . . . . . . .   4").append(NEWLINE)
                .append(". . . . . . . .   3").append(NEWLINE)
                .append("p p p p p p p p   2").append(NEWLINE)
                .append("r n b q k b n r   1").append(NEWLINE)
                .append(NEWLINE).append("a b c d e f g h ").toString();
        assertThat(board.getResultToPrint())
                .isEqualTo(result);
    }

    @Test
    void verifyGetNumberOfPieces() {
        board.initialize();
        assertThat(board.getNumberOfPieces(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.getNumberOfPieces(Color.WHITE, Type.KING)).isEqualTo(1);
    }

    @Test
    void verifyFindPiece() {
        board.initialize();
        assertAll(() -> assertThat(board.findPiece(new Position("a8")))
                        .isEqualTo(createPiece(Color.BLACK, Type.ROOK)),
                () -> assertThat(board.findPiece(new Position("e1")))
                        .isEqualTo(createPiece(Color.WHITE, Type.KING)));
    }

    @Test
    void verifyMove() {
        board.initializeEmpty();
        Position before = new Position("b6");
        Position after = new Position("d3");
        Piece blackQueen = createPiece(Color.BLACK, Type.QUEEN);

        board.addPiece(before, blackQueen);
        board.move(before, after);

        assertThat(board.findPiece(after)).isEqualTo(blackQueen);
    }

    @Test
    void verifyCalculatePoint() {
        board.initializeEmpty();

        addPiece("b6", createPiece(Color.BLACK, Type.PAWN));
        addPiece("e6", createPiece(Color.BLACK, Type.QUEEN));
        addPiece("b8", createPiece(Color.BLACK, Type.KING));
        addPiece("c8", createPiece(Color.BLACK, Type.ROOK));

        addPiece("f2", createPiece(Color.WHITE, Type.PAWN));
        addPiece("g2", createPiece(Color.WHITE, Type.PAWN));
        addPiece("e1", createPiece(Color.WHITE, Type.ROOK));
        addPiece("f1", createPiece(Color.WHITE, Type.KING));

        assertThat(board.calculatePoint(Color.BLACK)).isCloseTo(15.0, within(0.01));
        assertThat(board.calculatePoint(Color.WHITE)).isCloseTo(7.0, within(0.01));
    }

    private void addPiece(String position, Piece piece) {
        board.addPiece(new Position(position), piece);
    }

}

