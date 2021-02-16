package pieces;

import org.junit.jupiter.api.*;
import pieces.Piece.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("색상과 타입에 알맞게 말이 생성되었는지 검증한다")
    void createPiece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, 'p'),
                () -> verifyPiece(Piece.createWhiteKnight(), Color.WHITE, 'n'),
                () -> verifyPiece(Piece.createWhiteRook(), Color.WHITE, 'r'),
                () -> verifyPiece(Piece.createWhiteBishop(), Color.WHITE, 'b'),
                () -> verifyPiece(Piece.createWhiteQueen(), Color.WHITE, 'q'),
                () -> verifyPiece(Piece.createWhiteKing(), Color.WHITE, 'k'),

                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, 'P'),
                () -> verifyPiece(Piece.createBlackKnight(), Color.BLACK, 'N'),
                () -> verifyPiece(Piece.createBlackRook(), Color.BLACK, 'R'),
                () -> verifyPiece(Piece.createBlackBishop(), Color.BLACK, 'B'),
                () -> verifyPiece(Piece.createBlackQueen(), Color.BLACK, 'Q'),
                () -> verifyPiece(Piece.createBlackKing(), Color.BLACK, 'K')
        );
    }

    private void verifyPiece(final Piece piece, Color color, final char representation) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation));
    }
}



