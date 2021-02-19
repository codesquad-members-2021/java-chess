package net.tree.pieces;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PawnTest {

    @Test
    @DisplayName("흰색, 검정색 pawn이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);

    }

    void verifyPawn(final String color, final  char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
        assertThat(color ,equalTo(pawn.getColor()));
    }

    @Test
    @DisplayName("기본생성자 만들기")
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }
}