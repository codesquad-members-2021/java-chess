package chess.pieces;

import chess.pieces.Piece.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @DisplayName("기물의 representation이 올바르게 지정되었는지 확인한다.")
    @Test
    void getRepresentationPerPiece() {
        assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @DisplayName("기물의 타입과 color가 올바르게 지정되었는지 확인한다.")
    @Test
    void createPiece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);
    }

    @DisplayName("빈 기물의 속성이 올바르게 지정되었는지 확인한다.")
    @Test
    void createBlank() {
        Piece blank = Piece.createBlank();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    void verifyPiece(Piece whitePiece, Piece blackPiece, Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}