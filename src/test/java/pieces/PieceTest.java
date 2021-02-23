package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("폰의 색상을 가져오는 메소드와 이니셜을 가져오는 메소드가 잘 작동하는지 테스트")
     void create_Piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }
    void verifyPiece(final Piece piece, final String color, final char representation){
        Piece pawn = new Piece(color);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("생성자에 색상을 지정하지 않을때 흰색 폰이 생성되는지 테스트")
     void createBasicPawn(){
        Piece pawn = new Piece();
        assertThat(Piece.WHITE).isEqualTo(pawn.getColor());
        assertThat(Piece.WHITE_PAWN_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }
}
