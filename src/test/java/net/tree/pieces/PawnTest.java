package net.tree.pieces;


<<<<<<< HEAD
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
=======
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
>>>>>>> feat : Do Mission2

public class PawnTest {

    @Test
<<<<<<< HEAD
    @DisplayName("흰색, 검정색 pawn이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR);
        verifyPawn(Pawn.BLACK_COLOR);
=======
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
>>>>>>> feat : Do Mission2
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
<<<<<<< HEAD

    }

    @Test
    @DisplayName("기본생성자 만들기")
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
=======
        assertThat(color ,equalTo(pawn.getColor()));
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
>>>>>>> feat : Do Mission2
    }
}