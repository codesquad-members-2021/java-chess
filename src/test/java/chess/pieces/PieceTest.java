package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PieceTest {

    @Test
    @DisplayName("팩토리 메소드를 통해 각 기물은 알맞는 타입과 색상을 가져야한다.")
    void create_pieces() {
        verifyPiece(Piece.createWhitePawn()  , Piece.createBlackPawn(), Piece.Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook()  , Piece.createBlackRook(), Piece.Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen() , Piece.createBlackQueen(), Piece.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing()  , Piece.createBlackKing(), Piece.Type.KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Piece.Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece
            , final Piece blackPiece, Piece.Type type) {

        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("각 기물 별로 enum에 알맞는 변수 값을 갖고 있는지 확인한다.")
    void get_representation_per_piece() {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.KNIGHT.getWhiteRepresentation()).isEqualTo('n');
        assertThat(Piece.Type.ROOK.getWhiteRepresentation()).isEqualTo('r');
        assertThat(Piece.Type.BISHOP.getWhiteRepresentation()).isEqualTo('b');
        assertThat(Piece.Type.QUEEN.getWhiteRepresentation()).isEqualTo('q');
        assertThat(Piece.Type.KING.getWhiteRepresentation()).isEqualTo('k');

        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
        assertThat(Piece.Type.KNIGHT.getBlackRepresentation()).isEqualTo('N');
        assertThat(Piece.Type.ROOK.getBlackRepresentation()).isEqualTo('R');
        assertThat(Piece.Type.BISHOP.getBlackRepresentation()).isEqualTo('B');
        assertThat(Piece.Type.QUEEN.getBlackRepresentation()).isEqualTo('Q');
        assertThat(Piece.Type.KING.getBlackRepresentation()).isEqualTo('K');
    }

}
