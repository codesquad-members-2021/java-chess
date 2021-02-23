package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @DisplayName("기물의 representation이 잘 반환되는지 확인한다.")
    @Test
    void getRepresentationPerPiece(){
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @DisplayName("기물의 color가 잘 지정되었는지 확인한다.")
    @Test
    public void check_color() {
        assertThat(Piece.createBlackPawn().isBlack()).isTrue();
        assertThat(Piece.createBlackPawn().isWhite()).isFalse();
    }
}