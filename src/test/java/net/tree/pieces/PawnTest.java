package net.tree.pieces;


<<<<<<< HEAD
<<<<<<< HEAD
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
=======
import org.junit.Test;
=======
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

>>>>>>> feat : Do Mission2

import static org.hamcrest.CoreMatchers.equalTo;
<<<<<<< HEAD
import static org.junit.Assert.*;
>>>>>>> feat : Do Mission2
=======
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
>>>>>>> feat : Do Mission3

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PawnTest {

<<<<<<< HEAD
    @Test
<<<<<<< HEAD
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
=======
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation());
    }
=======
>>>>>>> feat : Do Mission2

    @Test
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
>>>>>>> feat : Do Mission3
    }

    void verifyPawn(final String color, final  char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertEquals(color, pawn.getColor());
<<<<<<< HEAD
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
=======
        assertEquals(representation, pawn.getRepresentation());
        assertThat(color ,equalTo(pawn.getColor()));
    }

<<<<<<< HEAD
>>>>>>> feat : Do Mission3
=======



>>>>>>> feat : Do Mission2
}