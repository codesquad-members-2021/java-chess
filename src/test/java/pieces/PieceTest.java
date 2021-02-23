package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("유닛의 객체를 만들고, 색상을 가져오는 메소드와 이니셜을 가져오는 메소드가 잘 작동하는지 테스트")
     void create_Piece() {
        verifyPiece(Piece.createWhitePawnInstance(), Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawnInstance(), Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
        verifyPiece(Piece.createWhiteRookInstance(), Piece.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRookInstance(), Piece.BLACK, Piece.BLACK_ROOK_REPRESENTATION);
        verifyPiece(Piece.createWhiteKnightInstance(), Piece.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnightInstance(), Piece.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createWhiteBishopInstance(), Piece.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishopInstance(), Piece.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createWhiteQueenInstance(), Piece.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueenInstance(), Piece.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createWhiteKingInstance(), Piece.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKingInstance(), Piece.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }
    void verifyPiece(final Piece piece, final String color, final char representation){
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}
