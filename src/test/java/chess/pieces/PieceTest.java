package chess.pieces;

import org.junit.jupiter.api.*;

import static chess.pieces.Piece.Type.*;
import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PieceTest {

    @Test
    @DisplayName("팩토리 메소드를 통해 각 기물은 알맞는 타입과 색상을 가져야한다.")
    void create_pieces() {
        verifyPiece(Piece.createWhite(PAWN)  , Piece.createBlack(PAWN), PAWN);
        verifyPiece(Piece.createWhite(KNIGHT), Piece.createBlack(KNIGHT), KNIGHT);
        verifyPiece(Piece.createWhite(ROOK)  , Piece.createBlack(ROOK), ROOK);
        verifyPiece(Piece.createWhite(BISHOP), Piece.createBlack(BISHOP), BISHOP);
        verifyPiece(Piece.createWhite(QUEEN) , Piece.createBlack(QUEEN), QUEEN);
        verifyPiece(Piece.createWhite(KING)  , Piece.createBlack(KING), KING);

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(NO_PIECE);
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
        assertThat(PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(KNIGHT.getWhiteRepresentation()).isEqualTo('n');
        assertThat(ROOK.getWhiteRepresentation()).isEqualTo('r');
        assertThat(BISHOP.getWhiteRepresentation()).isEqualTo('b');
        assertThat(QUEEN.getWhiteRepresentation()).isEqualTo('q');
        assertThat(KING.getWhiteRepresentation()).isEqualTo('k');

        assertThat(PAWN.getBlackRepresentation()).isEqualTo('P');
        assertThat(KNIGHT.getBlackRepresentation()).isEqualTo('N');
        assertThat(ROOK.getBlackRepresentation()).isEqualTo('R');
        assertThat(BISHOP.getBlackRepresentation()).isEqualTo('B');
        assertThat(QUEEN.getBlackRepresentation()).isEqualTo('Q');
        assertThat(KING.getBlackRepresentation()).isEqualTo('K');
    }

}
