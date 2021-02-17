package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, 'P');
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, 'n');
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, 'N');
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, 'b');
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, 'B');
        verifyPiece(Piece.createWhiteRook(), Color.WHITE, 'r');
        verifyPiece(Piece.createBlackRook(), Color.BLACK, 'R');
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, 'q');
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, 'Q');
        verifyPiece(Piece.createWhiteKing(), Color.WHITE, 'k');
        verifyPiece(Piece.createBlackKing(), Color.BLACK, 'K');
    }

    void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}