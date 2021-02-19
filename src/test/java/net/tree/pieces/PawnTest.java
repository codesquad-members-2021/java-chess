package net.tree.pieces;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색, 검정색 pawn이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());

    }

    @Test
    @DisplayName("기본생성자 만들기")
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}