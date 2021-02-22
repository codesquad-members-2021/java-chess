package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceTest {
    @Test
    @DisplayName("Verify create correct pieces")
    void create_piece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN),
                () -> verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN),
                () -> verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT),
                () -> verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT),
                () -> verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK),
                () -> verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK),
                () -> verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP),
                () -> verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP),
                () -> verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN),
                () -> verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN),
                () -> verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING),
                () -> verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING)
        );
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
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