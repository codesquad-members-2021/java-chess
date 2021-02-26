package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceTest {

    @Test
    @DisplayName("Verify create correct pieces")
    void create_piece() {
        Position position = new Position(1, 1);
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(position), Piece.createBlackPawn(position), Type.PAWN),
                () -> verifyPiece(Piece.createWhiteKnight(position), Piece.createBlackKnight(position), Type.KNIGHT),
                () -> verifyPiece(Piece.createWhiteRook(position), Piece.createBlackRook(position), Type.ROOK),
                () -> verifyPiece(Piece.createWhiteBishop(position), Piece.createBlackBishop(position), Type.BISHOP),
                () -> verifyPiece(Piece.createWhiteQueen(position), Piece.createBlackQueen(position), Type.QUEEN),
                () -> verifyPiece(Piece.createWhiteKing(position), Piece.createBlackKing(position), Type.KING)
        );

        Piece blank = Piece.createBlank(position);
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("Verify isWhite and isBlack")
    void verifyColor() {
        Position position = new Position(1, 1);
        Piece whitePawn = Piece.createWhitePawn(position);
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whitePawn.getRepresentation()).isEqualTo('p');

        Piece blackPawn = Piece.createBlackPawn(position);
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackPawn.getRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("Verify isWhitePawn and isBlackPawn")
    void verifyPawn() {
        Position position = new Position(1, 1);
        Piece whitePawn = Piece.createWhitePawn(position);
        Piece blackPawn = Piece.createBlackPawn(position);
        assertThat(whitePawn.isWhitePawn()).isTrue();
        assertThat(blackPawn.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("Verify getWhiteRepresentation and getBlackRepresentation")
    public void getRepresentationPerPiece() {
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