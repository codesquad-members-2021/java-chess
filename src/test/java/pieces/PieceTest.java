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

    @Test
    @DisplayName("색깔 별 체스말 Type 테스트")
    void checkPieceType() {
        softly.assertThat(Type.PAWN.getWhiteRepresentation()).as("White Pawn").isEqualTo('p');
        softly.assertThat(Type.PAWN.getBlackRepresentation()).as("Black Pawn").isEqualTo('P');
        softly.assertThat(Type.ROOK.getWhiteRepresentation()).as("White Rook").isEqualTo('r');
        softly.assertThat(Type.ROOK.getBlackRepresentation()).as("Black Rook").isEqualTo('R');
        softly.assertThat(Type.KNIGHT.getWhiteRepresentation()).as("White Knight").isEqualTo('n');
        softly.assertThat(Type.KNIGHT.getBlackRepresentation()).as("Black Knight").isEqualTo('N');
        softly.assertThat(Type.BISHOP.getWhiteRepresentation()).as("White Bishop").isEqualTo('b');
        softly.assertThat(Type.BISHOP.getBlackRepresentation()).as("Black Bishop").isEqualTo('B');
        softly.assertThat(Type.QUEEN.getWhiteRepresentation()).as("White Queen").isEqualTo('q');
        softly.assertThat(Type.QUEEN.getBlackRepresentation()).as("Black Queen").isEqualTo('Q');
        softly.assertThat(Type.KING.getWhiteRepresentation()).as("White King").isEqualTo('k');
        softly.assertThat(Type.KING.getBlackRepresentation()).as("Black King").isEqualTo('K');
        softly.assertThat(Type.NO_PIECE.getWhiteRepresentation()).as("No Piece (White)").isEqualTo('.');
        softly.assertThat(Type.NO_PIECE.getBlackRepresentation()).as("No Piece (Black)").isEqualTo('.');
    }

}
