package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("흰색 폰 생성")
    void createWhitePawn() {
        verifyPawn(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("검은색 폰 생성")
    void createBlackPawn() {
        verifyPawn(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPawn(final String color, final String representation){
        Piece piece = new Piece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("기본생성자로 폰 생성")
    public void createDefaultConstructor() {
        Piece piece = new Piece();
        assertThat(piece.getColor()).isEqualTo(Piece.WHITE);
        assertThat(piece.getRepresentation()).isEqualTo(Piece.WHITE_PAWN_REPRESENTATION);
    }

}
