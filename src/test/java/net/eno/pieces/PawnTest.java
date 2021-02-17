package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("기본 생성자 호출 시 흰색 폰이 생성되어야 한다")
    public void createDefaultConstructor() {
        Piece pawn = new Piece();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE.toString());
        assertThat(pawn.getRepresentation()).isEqualTo(Representation.WHITE.getPawn());
    }

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Color.WHITE, Representation.WHITE);
        verifyPawn(Color.BLACK, Representation.BLACK);
    }

    public void verifyPawn(Color color, Representation representation) {
        Piece pawn = new Piece(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color.toString());
        assertThat(pawn.getRepresentation()).isEqualTo(representation.getPawn());
    }

}
