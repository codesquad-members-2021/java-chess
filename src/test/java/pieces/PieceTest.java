package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("유닛의 객체를 만들고, 색상을 가져오는 메소드와 이니셜을 가져오는 메소드가 잘 작동하는지 테스트")
    void create_Piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK, Piece.BLACK_ROOK_REPRESENTATION);

        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }

    void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("흰색인지 검정색인지 구분해주는 테스트")
    void isWhiteAndBlack() {
        assertAll(
                () -> assertThat(Piece.createWhitePawn().isWhite()).isTrue(),
                () -> assertThat(Piece.createWhitePawn().isBlack()).isFalse(),
                () -> assertThat(Piece.createBlackPawn().isWhite()).isFalse(),
                () -> assertThat(Piece.createBlackPawn().isBlack()).isTrue()
        );
    }
}
