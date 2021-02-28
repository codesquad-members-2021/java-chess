package piece;

import org.junit.jupiter.api.*;

import static piece.PieceCreator.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("Verify create correct pieces")
    void create_piece() {
        Position position = new Position(1, 1);
        assertAll(
                () -> verifyPiece(createWhitePawn(position), createBlackPawn(position), Type.PAWN),
                () -> verifyPiece(createWhiteKnight(position), createBlackKnight(position), Type.KNIGHT),
                () -> verifyPiece(createWhiteRook(position), createBlackRook(position), Type.ROOK),
                () -> verifyPiece(createWhiteBishop(position), createBlackBishop(position), Type.BISHOP),
                () -> verifyPiece(createWhiteQueen(position), createBlackQueen(position), Type.QUEEN),
                () -> verifyPiece(createWhiteKing(position), createBlackKing(position), Type.KING)
        );

        Piece blank = createBlank(position);
        assertThat(blank.isRightColor(Color.WHITE)).isFalse();
        assertThat(blank.isRightColor(Color.BLACK)).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isRightColor(Color.WHITE)).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isRightColor(Color.BLACK)).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("Verify isWhite and isBlack")
    void verifyColor() {
        Position position = new Position(1, 1);
        Piece whitePawn = createWhitePawn(position);
        assertThat(whitePawn.isRightColor(Color.WHITE)).isTrue();
        assertThat(whitePawn.getRepresentation()).isEqualTo('p');

        Piece blackPawn = createBlackPawn(position);
        assertThat(blackPawn.isRightColor(Color.BLACK)).isTrue();
        assertThat(blackPawn.getRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("Verify isWhitePawn and isBlackPawn")
    void verifyPawn() {
        Position position = new Position(1, 1);
        Piece whitePawn = createWhitePawn(position);
        Piece blackPawn = createBlackPawn(position);
        assertThat(whitePawn.isWhitePawn()).isTrue();
        assertThat(blackPawn.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("Verify getWhiteRepresentation and getBlackRepresentation")
    void getRepresentationPerPiece() {
        assertAll(
                () -> assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p'),
                () -> assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P'),
                () -> assertThat(Type.KNIGHT.getWhiteRepresentation()).isEqualTo('n'),
                () -> assertThat(Type.KNIGHT.getBlackRepresentation()).isEqualTo('N'),
                () -> assertThat(Type.ROOK.getWhiteRepresentation()).isEqualTo('r'),
                () -> assertThat(Type.ROOK.getBlackRepresentation()).isEqualTo('R'),
                () -> assertThat(Type.BISHOP.getWhiteRepresentation()).isEqualTo('b'),
                () -> assertThat(Type.BISHOP.getBlackRepresentation()).isEqualTo('B'),
                () -> assertThat(Type.QUEEN.getWhiteRepresentation()).isEqualTo('q'),
                () -> assertThat(Type.QUEEN.getBlackRepresentation()).isEqualTo('Q'),
                () -> assertThat(Type.KING.getWhiteRepresentation()).isEqualTo('k'),
                () -> assertThat(Type.KING.getBlackRepresentation()).isEqualTo('K')
        );
    }

}