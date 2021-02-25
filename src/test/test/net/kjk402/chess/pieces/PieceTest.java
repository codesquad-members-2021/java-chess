package net.kjk402.chess.pieces;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PieceTest {
    private Position position;
    @Test
    @DisplayName("모든 말을 색상별로 생성하여 확인한다.")
    void create_allPieces() {
        verifyPiece(Piece.createWhitePawn(position), Piece.Color.WHITE, Piece.Type.PAWN);
        verifyPiece(Piece.createBlackPawn(position), Piece.Color.BLACK, Piece.Type.PAWN);
        verifyPiece(Piece.createWhiteRook(position), Piece.Color.WHITE, Piece.Type.ROOK);
        verifyPiece(Piece.createBlackRook(position), Piece.Color.BLACK, Piece.Type.ROOK);
        verifyPiece(Piece.createWhiteKnight(position), Piece.Color.WHITE, Piece.Type.KNIGHT);
        verifyPiece(Piece.createBlackKnight(position), Piece.Color.BLACK, Piece.Type.KNIGHT);
        verifyPiece(Piece.createWhiteBishop(position), Piece.Color.WHITE, Piece.Type.BISHOP);
        verifyPiece(Piece.createBlackBishop(position), Piece.Color.BLACK, Piece.Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(position),Piece.Color.WHITE, Piece.Type.QUEEN);
        verifyPiece(Piece.createBlackQueen(position), Piece.Color.BLACK, Piece.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(position), Piece.Color.WHITE, Piece.Type.KING);
        verifyPiece(Piece.createBlackKing(position), Piece.Color.BLACK, Piece.Type.KING);
    }

    private void verifyPiece(final Piece piece, Piece.Color color, Piece.Type representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }
    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo(Piece.Type.PAWN.getWhiteRepresentation());
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo(Piece.Type.PAWN.getBlackRepresentation());
    }

}
