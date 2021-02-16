package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 하며 올바른 출력값을 가져야 한다.")
    void create_white_and_black_pawns() {
        Pawn white = Pawn.newWhitePawn();
        Pawn black = Pawn.newBlackPawn();

        assertAll(
                () -> assertThat(white.getColor()).isEqualTo(Pawn.WHITE_COLOR),
                () -> assertThat(white.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION)
        );

        assertAll(
                () -> assertThat(black.getColor()).isEqualTo(Pawn.BLACK_COLOR),
                () -> assertThat(black.getRepresentation()).isEqualTo(Pawn.BLACK_REPRESENTATION)
        );
    }

}
