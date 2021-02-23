package chess;

import org.junit.jupiter.api.*;
import piece.PieceFactory;
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
        board.initialize();
    }

    @Test
    @DisplayName("체스판이 제대로 초기화되었는지 검증한다")
    void verifyInitialize() {
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
        assertThat(board.getNumberOfPieces(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.getNumberOfPieces(Color.WHITE, Type.KING)).isEqualTo(1);
    }

    @Test
    void verifyFindPiece() {
        assertAll(() -> assertThat(board.findPiece("a8")).isEqualTo(createPiece(Color.BLACK, Type.ROOK)),
                () -> assertThat(board.findPiece("e1")).isEqualTo(createPiece(Color.WHITE, Type.KING)));
    }
}

