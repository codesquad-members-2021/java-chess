package pieces;

import org.junit.jupiter.api.*;
import pieces.Piece.Color;
import pieces.Piece.Type;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("색상과 타입에 알맞게 말이 생성되어야 한다")
    void createPiece() {
        assertAll(() -> verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN),
                () -> verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT),
                () -> verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK),
                () -> verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP),
                () -> verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN),
                () -> verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING),
                () -> assertThat(Piece.createBlank().isWhite()).isFalse(),
                () -> assertThat(Piece.createBlank().isBlack()).isFalse());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertAll(() -> assertThat(whitePiece.isWhite()).isTrue(),
                () -> assertThat(whitePiece.getType()).isEqualTo(type),
                () -> assertThat(blackPiece.isBlack()).isTrue(),
                () -> assertThat(blackPiece.getType()).isEqualTo(type));
    }

    @Test
    @DisplayName("말이 흰색이면 true, 아니면 false를 반환해야 한다")
    void verifyIsWhite() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackKnight = Piece.createBlackKnight();

        assertAll(() -> assertThat(whitePawn.isWhite()).isTrue(),
                () -> assertThat(whitePawn.getRepresentation()).isEqualTo('p'),
                () -> assertThat(blackKnight.isWhite()).isFalse(),
                () -> assertThat(blackKnight.getRepresentation()).isEqualTo('N'));
    }

    @Test
    @DisplayName("말이 검은색이면 true, 아니면 false를 반환해야 한다")
    void verifyIsBlack() {
        Piece whiteQueen = Piece.createWhiteQueen();
        Piece blackKing = Piece.createBlackKing();
        assertAll(() -> assertThat(whiteQueen.isBlack()).isEqualTo(false),
                () -> assertThat(whiteQueen.getRepresentation()).isEqualTo('q'),
                () -> assertThat(blackKing.isBlack()).isEqualTo(true),
                () -> assertThat(blackKing.getRepresentation()).isEqualTo('K'));
    }
}

