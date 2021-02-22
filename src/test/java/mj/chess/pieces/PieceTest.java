package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("체스말 생성에 따라 색, 타입, 표현문자 상태 확인 ")
    void createPiece() {
        assertAll(
                () -> verifyPiece(Piece.PieceMaker.createWhitePawn(), Color.WHITE, Type.PAWN),
                () -> verifyPiece(Piece.PieceMaker.createBlackPawn(), Color.BLACK, Type.PAWN)
        );
    }

    private void verifyPiece(final Piece piece, Color color, Type type) {
        String representation = type.getRepresentation(color);

        assertAll(
                () -> verifyColorOfPiece(piece, color),
                () -> verifyTypeOfPiece(piece, type),
                () -> verifyRepresentationOfPiece(piece, representation)
        );
    }

    private void verifyColorOfPiece(final Piece piece, Color color) {
        assertThat(piece.getColor()).isEqualTo(color);
    }

    private void verifyTypeOfPiece(final Piece piece, Type type) {
        assertThat(piece.getType()).isEqualTo(type);
    }

    private void verifyRepresentationOfPiece(final Piece piece, final String representation) {
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("모든 기물에 대해 흑백 상태 확인")
    void checkIsWhiteOrBlack() {
        for (Type eachType : Type.values()) {
            assertAll(
                    () -> verifyIsBlack(eachType),
                    () -> verifyIsWhite(eachType)
            );
        }
    }

    private void verifyIsWhite(Type type) {
        switch (type) {
            case PAWN:
                assertThat(Piece.PieceMaker.createWhitePawn().isWhite()).isTrue();
                break;
            case KNIGHT:
                assertThat(Piece.PieceMaker.createWhiteKnight().isWhite()).isTrue();
                break;
            case ROOK:
                assertThat(Piece.PieceMaker.createWhiteRook().isWhite()).isTrue();
                break;
            case BISHOP:
                assertThat(Piece.PieceMaker.createWhiteBishop().isWhite()).isTrue();
                break;
            case QUEEN:
                assertThat(Piece.PieceMaker.createWhiteQueen().isWhite()).isTrue();
                break;
            case KING:
                assertThat(Piece.PieceMaker.createWhiteKing().isWhite()).isTrue();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private void verifyIsBlack(Type type) {
        switch (type) {
            case PAWN:
                assertThat(Piece.PieceMaker.createBlackPawn().isBlack()).isTrue();
                break;
            case KNIGHT:
                assertThat(Piece.PieceMaker.createBlackKnight().isBlack()).isTrue();
                break;
            case ROOK:
                assertThat(Piece.PieceMaker.createBlackRook().isBlack()).isTrue();
                break;
            case BISHOP:
                assertThat(Piece.PieceMaker.createBlackBishop().isBlack()).isTrue();
                break;
            case QUEEN:
                assertThat(Piece.PieceMaker.createBlackQueen().isBlack()).isTrue();
                break;
            case KING:
                assertThat(Piece.PieceMaker.createBlackKing().isBlack()).isTrue();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
