package chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 하며 올바른 출력값을 가져야 한다.")
    void create_white_and_black_pawns() {
        assertAll(
                () -> verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION),
                () -> verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION)
        );
    }

    void verifyPawn(final String color, final String representation) {
        Pawn pawn = new Pawn(color, representation);
        assertAll(
                () -> assertEquals(color, pawn.getColor()),
                () -> assertEquals(representation, pawn.getRepresentation())
        );
    }

    @Test
    @DisplayName("기본생성자로 흰색 폰이 생성되고 출력값으로 'p' 를 가져야한다.")
    void create_default_constructor() throws Exception {
        Pawn pawn = new Pawn();
        assertAll(
                () -> assertEquals(Pawn.WHITE_COLOR, pawn.getColor()),
                () -> assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation())
        );
    }

}
