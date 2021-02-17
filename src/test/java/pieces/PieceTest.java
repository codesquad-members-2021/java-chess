package pieces;

import org.junit.jupiter.api.*;
import pieces.Piece.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("색상과 출력 양식에 알맞게 말이 생성되어야 한다")
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

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation));
    }

    @Test
    @DisplayName("말이 흰색이면 true, 아니면 false를 반환해야 한다")
    void verifyIsWhite() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackKnight = Piece.createBlackKnight();
        assertThat(whitePawn.isWhite()).isEqualTo(true);
        assertThat(blackKnight.isWhite()).isEqualTo(false);
    }

    @Test
    @DisplayName("말이 검은색이면 true, 아니면 false를 반환해야 한다")
    void verifyIsBlack() {
        Piece whiteQueen = Piece.createWhiteQueen();
        Piece blackKing = Piece.createBlackKing();
        assertThat(whiteQueen.isBlack()).isEqualTo(false);
        assertThat(blackKing.isBlack()).isEqualTo(true);
    }
}

