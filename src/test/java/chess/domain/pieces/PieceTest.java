package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PieceTest {

    @Test
    @DisplayName("기물의 점수가 낮은 순으로 정렬")
    void compareTo_increase() {
        List<Piece> pieces = Arrays.asList(King.ofBlack(), Pawn.ofBlack(), Bishop.ofBlack(), Queen.ofBlack(), Pawn.ofBlack(), Knight.ofBlack(), Rook.ofBlack());
        Collections.sort(pieces);
        assertThat(pieces).isEqualTo(Arrays.asList(
                King.ofBlack(),
                Pawn.ofBlack(),
                Pawn.ofBlack(),
                Knight.ofBlack(),
                Bishop.ofBlack(),
                Rook.ofBlack(),
                Queen.ofBlack()
        ));
    }

    @Test
    @DisplayName("기물의 점수가 높은 순으로 정렬")
    void compareTo_decrease() {
        List<Piece> pieces = Arrays.asList(King.ofWhite(), Pawn.ofWhite(), Bishop.ofWhite(), Queen.ofWhite(), Pawn.ofWhite(), Knight.ofWhite(), Rook.ofWhite());
        Collections.sort(pieces, Collections.reverseOrder());
        assertThat(pieces).isEqualTo(Arrays.asList(
                Queen.ofWhite(),
                Rook.ofWhite(),
                Bishop.ofWhite(),
                Knight.ofWhite(),
                Pawn.ofWhite(),
                Pawn.ofWhite(),
                King.ofWhite()
        ));
    }
}
