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
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN),
                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN)
        );
    }

    ;

    private void verifyPiece(final Piece piece, Color color, Type type) {
        String representation = new RepresentationMap().getRepresentation(color, type);

        assertAll(
                () -> verifyColorOfPiece(piece, color),
                () -> verifyTypeOfPiece(piece, type),
                () -> verifyRepresentationOfPiece(piece, representation)
        );
    }

    ;

    private void verifyColorOfPiece(final Piece piece, Color color) {
        assertThat(piece.getColor()).isEqualTo(color);
    }

    ;

    private void verifyTypeOfPiece(final Piece piece, Type type) {
        assertThat(piece.getType()).isEqualTo(type);
    }

    ;

    private void verifyRepresentationOfPiece(final Piece piece, final String representation) {
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    ;

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
                assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
                break;
            case KNIGHT:
                assertThat(Piece.createWhiteKnight().isWhite()).isEqualTo(true);
                break;
            case ROOK:
                assertThat(Piece.createWhiteRook().isWhite()).isEqualTo(true);
                break;
            case BISHOP:
                assertThat(Piece.createWhiteBishop().isWhite()).isEqualTo(true);
                break;
            case QUEEN:
                assertThat(Piece.createWhiteQueen().isWhite()).isEqualTo(true);
                break;
            case KING:
                assertThat(Piece.createWhiteKing().isWhite()).isEqualTo(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private void verifyIsBlack(Type type) {
        switch (type) {
            case PAWN:
                assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
                break;
            case KNIGHT:
                assertThat(Piece.createBlackKnight().isBlack()).isEqualTo(true);
                break;
            case ROOK:
                assertThat(Piece.createBlackRook().isBlack()).isEqualTo(true);
                break;
            case BISHOP:
                assertThat(Piece.createBlackBishop().isBlack()).isEqualTo(true);
                break;
            case QUEEN:
                assertThat(Piece.createBlackQueen().isBlack()).isEqualTo(true);
                break;
            case KING:
                assertThat(Piece.createBlackKing().isBlack()).isEqualTo(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
