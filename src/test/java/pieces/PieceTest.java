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
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

        Piece blank = Piece.createBlank();
        softly.assertThat(blank.isWhite()).as("빈칸 색상(흰색) 확인").isFalse();
        softly.assertThat(blank.isBlack()).as("빈칸 색상(검은색) 확인").isFalse();
        softly.assertThat(blank.getType()).as("빈칸 타입").isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(Piece whitePiece, Piece blackPiece, Type type) {
        softly.assertThat(whitePiece.isWhite()).as("흰색 말 색상이 흰색인지").isTrue();
        softly.assertThat(whitePiece.isBlack()).as("흰색 말 색상이 검은색인지").isFalse();
        softly.assertThat(whitePiece.getType()).as("흰색 말 타입").isEqualTo(type);

        softly.assertThat(blackPiece.isBlack()).as("검은색 말 색상이 검은색인지").isTrue();
        softly.assertThat(blackPiece.isWhite()).as("검은색 말 색상이 흰색인지").isFalse();
        softly.assertThat(blackPiece.getType()).as("검은색 말 타입").isEqualTo(type);
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
