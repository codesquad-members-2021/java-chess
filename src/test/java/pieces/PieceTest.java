package pieces;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;

class PieceTest {
    SoftAssertions softly;

    @BeforeEach
    void testInit() {
        softly = new SoftAssertions();
    }

    @AfterEach
    void afterTest() {
        softly.assertAll();
    }

    @Test
    @DisplayName("모든 종류의 체스 말 생성 테스트")
    void create_pieces() {
        verifyPiece(Piece.createWhitePawn  (), Color.WHITE, 'p');
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, 'n');
        verifyPiece(Piece.createWhiteRook  (), Color.WHITE, 'r');
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, 'b');
        verifyPiece(Piece.createWhiteQueen (), Color.WHITE, 'q');
        verifyPiece(Piece.createWhiteKing  (), Color.WHITE, 'k');

        verifyPiece(Piece.createBlackPawn  (), Color.BLACK, 'P');
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, 'N');
        verifyPiece(Piece.createBlackRook  (), Color.BLACK, 'R');
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, 'B');
        verifyPiece(Piece.createBlackQueen (), Color.BLACK, 'Q');
        verifyPiece(Piece.createBlackKing  (), Color.BLACK, 'K');
    }

    private void verifyPiece(Piece piece, Color color, char representation) {
        softly.assertThat(piece.getColor()).isEqualTo(color);
        softly.assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("체스 말이 흰색인지 검은색인지 확인")
    void checkPieceColor() {
        Piece blackPiece = Piece.createBlackPawn();
        Piece whitePiece = Piece.createWhitePawn();

        softly.assertThat(blackPiece.isBlack()).isEqualTo(true);
        softly.assertThat(blackPiece.isWhite()).isEqualTo(false);
        softly.assertThat(whitePiece.isBlack()).isEqualTo(false);
        softly.assertThat(whitePiece.isWhite()).isEqualTo(true);
    }

}
