package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("흑폰 백폰이 제대로 생성되는지 확인")
    void createPawnPiece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("흑나이트 백나이트가 제대로 생성되는지 확인")
    void createKnightPiece() {
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    @Test
    @DisplayName("흑룩 백룩이 제대로 생성되는지 확인")
    void createRookPiece() {
        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION);
    }

    @Test
    @DisplayName("흑비숍 백비숏이 제대로 생성되는지 확인")
    void createBishopPiece() {
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);
    }

    @Test
    @DisplayName("흑퀸 백퀸이 제대로 생성되는지 확인")
    void createQueenPiece() {
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    @Test
    @DisplayName("흑킹 백킹이 제대로 생성되는지 확인")
    void createKingPiece() {
        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }

    void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }

    @Test
    @DisplayName("생성된 기물이 폰이 맞는지 확인")
    void checkPawn() {
        assertThat(Piece.createBlackPawn().isPawn()).isTrue();
        assertThat(Piece.createWhiteBishop().isPawn()).isFalse();
    }

    @Test
    @DisplayName("생성된 기물의 색이 올바른지 확인")
    void checkColor() {
        assertAll(
                () -> assertThat(Piece.createWhiteBishop().isWhite()).isTrue(),
                () -> assertThat(Piece.createBlackBishop().isBlack()).isTrue(),
                () -> assertThat(Piece.createWhiteKing().isBlack()).isFalse(),
                () -> assertThat(Piece.createBlackKing().isWhite()).isFalse()
        );
    }
}
