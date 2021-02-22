package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceTest {

    @Test
    @DisplayName("Verify create correct pieces")
    void create_piece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN),
                () -> verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Piece.Type.KNIGHT),
                () -> verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Piece.Type.ROOK),
                () -> verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Piece.Type.BISHOP),
                () -> verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Piece.Type.QUEEN),
                () -> verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Piece.Type.KING)
        );

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Piece.Type.NO_PIECE);
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("Verify isWhite and isBlack")
    void verifyColor() {
        assertThat(Piece.createWhitePawn().isWhite()).isTrue();
        assertThat(Piece.createBlackPawn().isBlack()).isTrue();
    }

    @Test
    @DisplayName("Verify isWhitePawn and isBlackPawn")
    void verifyPawn() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();
        assertThat(whitePawn.isWhitePawn()).isTrue();
        assertThat(blackPawn.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("Verify getWhiteRepresentation and getBlackRepresentation")
    public void getRepresentationPerPiece() {
        assertAll(
                () -> assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p'),
                () -> assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P'),
                () -> assertThat(Piece.Type.KNIGHT.getWhiteRepresentation()).isEqualTo('n'),
                () -> assertThat(Piece.Type.KNIGHT.getBlackRepresentation()).isEqualTo('N'),
                () -> assertThat(Piece.Type.ROOK.getWhiteRepresentation()).isEqualTo('r'),
                () -> assertThat(Piece.Type.ROOK.getBlackRepresentation()).isEqualTo('R'),
                () -> assertThat(Piece.Type.BISHOP.getWhiteRepresentation()).isEqualTo('b'),
                () -> assertThat(Piece.Type.BISHOP.getBlackRepresentation()).isEqualTo('B'),
                () -> assertThat(Piece.Type.QUEEN.getWhiteRepresentation()).isEqualTo('q'),
                () -> assertThat(Piece.Type.QUEEN.getBlackRepresentation()).isEqualTo('Q'),
                () -> assertThat(Piece.Type.KING.getWhiteRepresentation()).isEqualTo('k'),
                () -> assertThat(Piece.Type.KING.getBlackRepresentation()).isEqualTo('K')
        );
    }

}