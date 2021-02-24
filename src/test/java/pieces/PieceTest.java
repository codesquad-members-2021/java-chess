package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("흰색 폰 생성")
    void createWhitePawn() {
        verifyPawn(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION, Piece.PAWN);
    }

    @Test
    @DisplayName("검은색 폰 생성")
    void createBlackPawn() {
        verifyPawn(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION, Piece.BLACK);
    }

    private void verifyPawn(final String color, final String representation, final String name){
        Piece piece = new Piece(color, representation, name);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

}
