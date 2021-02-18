package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("하얀색 폰은 p를 출력해야한다.")
    void verifyWhitePawnRepresentation() {
        Piece piece = new Piece(Color.WHITE);
        verifyPawn(piece, Color.WHITE);
    }

    @Test
    @DisplayName("검은색 폰은 P를 출력해야한다.")
    void verifyBlackPawnRepresentation() {
        Piece piece = new Piece(Color.BLACK);
        verifyPawn(piece, Color.BLACK);
    }

    private void verifyPawn(Piece piece, Color color) {
        assertAll(
                () -> assertThat(piece.getColorName()).isEqualTo(color.getColorName()),
                () -> assertThat(piece.getRepresentation()).isEqualTo(color.getRepresentation())
        );
    }

}
