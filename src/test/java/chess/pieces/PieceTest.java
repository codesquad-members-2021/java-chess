package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void create_piece() {
        char rep = PieceName.PAWN.getTempRepresentation();
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, rep);
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Character.toUpperCase(rep));

        rep = PieceName.KNIGHT.getTempRepresentation();
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, rep);
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Character.toUpperCase(rep));

        rep = PieceName.BISHOP.getTempRepresentation();
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, rep);
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Character.toUpperCase(rep));

        rep = PieceName.ROOK.getTempRepresentation();
        verifyPiece(Piece.createWhiteRook(), Color.WHITE, rep);
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Character.toUpperCase(rep));

        rep = PieceName.QUEEN.getTempRepresentation();
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, rep);
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Character.toUpperCase(rep));

        rep = PieceName.KING.getTempRepresentation();
        verifyPiece(Piece.createWhiteKing(), Color.WHITE, rep);
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Character.toUpperCase(rep));
    }

    @Test
    public void check_color() {
        assertEquals(true, Piece.createBlackPawn().isBlack());
        assertEquals(false, Piece.createBlackPawn().isWhite());
    }

    void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}