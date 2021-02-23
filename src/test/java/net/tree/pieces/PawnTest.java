package net.tree.pieces;

<<<<<<< HEAD

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;
=======
import org.junit.Test;
=======
import org.junit.jupiter.api.Test;
=======
>>>>>>> rebase mission3
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

>>>>>>> feat : Do Mission2

=======
>>>>>>> feat : Do Mission2
import static org.hamcrest.CoreMatchers.equalTo;
<<<<<<< HEAD
<<<<<<< HEAD
import static org.junit.Assert.*;
>>>>>>> feat : Do Mission2
=======
=======

>>>>>>> feat : Do Mission3
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
>>>>>>> feat : Do Mission3

public class PawnTest {

<<<<<<< HEAD
<<<<<<< HEAD
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
=======

>>>>>>> feat : Do Mission3
    public void create_기본생성자() throws Exception {
=======
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


 class PawnTest {

    @DisplayName("기본생성자로 생성한 pawn")
    @Test
<<<<<<< HEAD
    public void create_기본생성자() {
>>>>>>> fix : mission3
=======
    void createPawnByDefaultConstructor() {
>>>>>>> Dion이 리뷰해주신 내용 반영하다.
        Pawn pawn = new Pawn();
        Assertions.assertAll(
                () -> assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR),
                () -> assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION)
        );
    }
<<<<<<< HEAD
=======
>>>>>>> feat : Do Mission2

=======
>>>>>>> rebase mission3
=======

<<<<<<< HEAD
    @DisplayName("")
>>>>>>> feat : Do Mission3
=======
    @DisplayName("color, representation 매개변수로 받아서 생성한 pawn")
>>>>>>> fix : mission3
    @Test
    void createPawn() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
<<<<<<< HEAD
>>>>>>> feat : Do Mission3
=======

>>>>>>> fix : Fix mission1
    }

    void verifyPawn(final String color, final  char representation) {
        Pawn pawn = new Pawn(color, representation);
<<<<<<< HEAD
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
=======

        Assertions.assertAll(
            () -> assertThat(pawn.getColor()).isEqualTo(color),
            () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );

>>>>>>> fix : mission3
    }
<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> feat : Do Mission3
=======



>>>>>>> feat : Do Mission2
=======
    @Test
    @DisplayName("기본생성자 만들기")
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }
>>>>>>> rebase mission3
=======
    
>>>>>>> feat : Do Mission2
=======

<<<<<<< HEAD
>>>>>>> feat : Do Mission3
}
=======
}
>>>>>>> kyu가 리뷰해준 내용 반영하였습니다.
