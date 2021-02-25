package chess.pieces;

import chess.Position;
import org.junit.jupiter.api.*;

import static chess.pieces.Piece.Color.BLACK;
import static chess.pieces.Piece.Color.WHITE;
import static chess.pieces.Piece.Type.*;
import static chess.pieces.Piece.*;
import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PieceTest {

    @Test
    @DisplayName("팩토리 메소드를 통해 각 기물은 알맞는 타입과 색상을 가져야한다.")
    void create_pieces() {
        verifyPiece(Piece.createWhite(PAWN, new Position("a1"))  , Piece.createBlack(PAWN, new Position("a1")), PAWN);
        verifyPiece(Piece.createWhite(KNIGHT, new Position("a1")), Piece.createBlack(KNIGHT, new Position("a1")), KNIGHT);
        verifyPiece(Piece.createWhite(ROOK, new Position("a1"))  , Piece.createBlack(ROOK, new Position("a1")), ROOK);
        verifyPiece(Piece.createWhite(BISHOP, new Position("a1")), Piece.createBlack(BISHOP, new Position("a1")), BISHOP);
        verifyPiece(Piece.createWhite(QUEEN, new Position("a1")) , Piece.createBlack(QUEEN, new Position("a1")), QUEEN);
        verifyPiece(Piece.createWhite(KING, new Position("a1"))  , Piece.createBlack(KING, new Position("a1")), KING);

        Piece blank = Piece.createBlank(new Position("a1"));
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece
            , final Piece blackPiece, Type type) {

        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("각 기물 별로 enum에 알맞는 변수 값을 갖고 있는지 확인한다.")
    void get_representation_per_piece() {
        assertThat(PAWN.getRepresentationWith(WHITE)).isEqualTo('p');
        assertThat(KNIGHT.getRepresentationWith(WHITE)).isEqualTo('n');
        assertThat(ROOK.getRepresentationWith(WHITE)).isEqualTo('r');
        assertThat(BISHOP.getRepresentationWith(WHITE)).isEqualTo('b');
        assertThat(QUEEN.getRepresentationWith(WHITE)).isEqualTo('q');
        assertThat(KING.getRepresentationWith(WHITE)).isEqualTo('k');

        assertThat(PAWN.getRepresentationWith(BLACK)).isEqualTo('P');
        assertThat(KNIGHT.getRepresentationWith(BLACK)).isEqualTo('N');
        assertThat(ROOK.getRepresentationWith(BLACK)).isEqualTo('R');
        assertThat(BISHOP.getRepresentationWith(BLACK)).isEqualTo('B');
        assertThat(QUEEN.getRepresentationWith(BLACK)).isEqualTo('Q');
        assertThat(KING.getRepresentationWith(BLACK)).isEqualTo('K');
    }

}
