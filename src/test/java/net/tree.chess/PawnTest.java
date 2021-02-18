package net.tree.chess;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
        assertThat(color ,equalTo(pawn.getColor()));
    }
}