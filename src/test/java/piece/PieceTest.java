package piece;

import static org.junit.jupiter.api.Assertions.*;

import pieces.Piece;
import org.junit.jupiter.api.*;

class PieceTest {

    @Test
    @DisplayName("create Piece test")
    public void create() {
        verifyPawn(Piece.createWhitePawn(), Piece.createWhitePawn().getColor(), Piece.createWhitePawn().getRepresentation());
        verifyPawn(Piece.createBlackPawn(), Piece.createBlackPawn().getColor(), Piece.createBlackPawn().getRepresentation());

        verifyPawn(Piece.createWhiteKnight(), Piece.createWhiteKnight().getColor(), Piece.createWhiteKnight().getRepresentation());
        verifyPawn(Piece.createBlackKnight(), Piece.createBlackKnight().getColor(), Piece.createBlackKnight().getRepresentation());

        verifyPawn(Piece.createWhiteRook(), Piece.createWhiteRook().getColor(), Piece.createWhiteRook().getRepresentation());
        verifyPawn(Piece.createBlackRook(), Piece.createBlackRook().getColor(), Piece.createBlackRook().getRepresentation());

        verifyPawn(Piece.createWhiteBishop(), Piece.createWhiteBishop().getColor(), Piece.createWhiteBishop().getRepresentation());
        verifyPawn(Piece.createBlackBishop(), Piece.createBlackBishop().getColor(), Piece.createBlackBishop().getRepresentation());

        verifyPawn(Piece.createWhiteQueen(), Piece.createWhiteQueen().getColor(), Piece.createWhiteQueen().getRepresentation());
        verifyPawn(Piece.createBlackQueen(), Piece.createBlackQueen().getColor(), Piece.createBlackQueen().getRepresentation());

        verifyPawn(Piece.createWhiteKing(), Piece.createWhiteKing().getColor(), Piece.createWhiteKing().getRepresentation());
        verifyPawn(Piece.createBlackKing(), Piece.createBlackKing().getColor(), Piece.createBlackKing().getRepresentation());

    }

    public void verifyPawn(Piece piece, Piece.Color color, Piece.PieceRepresentation representation){
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

}