package piece;

import static org.junit.jupiter.api.Assertions.*;

import pieces.Piece;
import org.junit.jupiter.api.*;

class PieceTest {

    @Test
    @DisplayName("create Piece test")
    public void create() {
        verifyPawn(Piece.createWhitePawn(), Piece.createWhitePawn().getColor(), Piece.createWhitePawn().getRepresentation());
    }

    public void verifyPawn(Piece piece, Piece.Color color, Piece.PieceRepresentation representation){
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }


    
}