package net.shion.chess.pieces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PieceTest {

    @Test
    @DisplayName("팩토리 메소드를 통해 각 기물은 알맞는 타입과 색상을 가져야한다.")
    void create_pieces() {
        verifyPiece(Piece.createWhite(Piece.Type.PAWN, new Position("a1"))  , Piece.createBlack(Piece.Type.PAWN, new Position("a1")), Piece.Type.PAWN);
        verifyPiece(Piece.createWhite(Piece.Type.KNIGHT, new Position("a1")), Piece.createBlack(Piece.Type.KNIGHT, new Position("a1")), Piece.Type.KNIGHT);
        verifyPiece(Piece.createWhite(Piece.Type.ROOK, new Position("a1"))  , Piece.createBlack(Piece.Type.ROOK, new Position("a1")), Piece.Type.ROOK);
        verifyPiece(Piece.createWhite(Piece.Type.BISHOP, new Position("a1")), Piece.createBlack(Piece.Type.BISHOP, new Position("a1")), Piece.Type.BISHOP);
        verifyPiece(Piece.createWhite(Piece.Type.QUEEN, new Position("a1")) , Piece.createBlack(Piece.Type.QUEEN, new Position("a1")), Piece.Type.QUEEN);
        verifyPiece(Piece.createWhite(Piece.Type.KING, new Position("a1"))  , Piece.createBlack(Piece.Type.KING, new Position("a1")), Piece.Type.KING);

        Piece blank = Piece.createBlank(new Position("a1"));
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
        Assertions.assertThat(Piece.Type.PAWN.getRepresentationWith(Piece.Color.WHITE)).isEqualTo('p');
        Assertions.assertThat(Piece.Type.KNIGHT.getRepresentationWith(Piece.Color.WHITE)).isEqualTo('n');
        Assertions.assertThat(Piece.Type.ROOK.getRepresentationWith(Piece.Color.WHITE)).isEqualTo('r');
        Assertions.assertThat(Piece.Type.BISHOP.getRepresentationWith(Piece.Color.WHITE)).isEqualTo('b');
        Assertions.assertThat(Piece.Type.QUEEN.getRepresentationWith(Piece.Color.WHITE)).isEqualTo('q');
        Assertions.assertThat(Piece.Type.KING.getRepresentationWith(Piece.Color.WHITE)).isEqualTo('k');

        Assertions.assertThat(Piece.Type.PAWN.getRepresentationWith(Piece.Color.BLACK)).isEqualTo('P');
        Assertions.assertThat(Piece.Type.KNIGHT.getRepresentationWith(Piece.Color.BLACK)).isEqualTo('N');
        Assertions.assertThat(Piece.Type.ROOK.getRepresentationWith(Piece.Color.BLACK)).isEqualTo('R');
        Assertions.assertThat(Piece.Type.BISHOP.getRepresentationWith(Piece.Color.BLACK)).isEqualTo('B');
        Assertions.assertThat(Piece.Type.QUEEN.getRepresentationWith(Piece.Color.BLACK)).isEqualTo('Q');
        Assertions.assertThat(Piece.Type.KING.getRepresentationWith(Piece.Color.BLACK)).isEqualTo('K');
    }

}
