package net.tree.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @DisplayName("기본생성자로 생성한 pawn")
    @Test
    public void create_기본생성자() {
        Pawn pawn = new Pawn();
        Assertions.assertAll(
                () -> assertEquals(Pawn.WHITE_COLOR, pawn.getColor()),
                () -> assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation())
        );
    }

    @DisplayName("color, representation 매개변수로 받아서 생성한 pawn")
    @Test
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);

    }

    void verifyPawn(final String color, final  char representation) {
        Pawn pawn = new Pawn(color, representation);

        Assertions.assertAll(
            () -> assertEquals(color, pawn.getColor()),
            () -> assertEquals(representation, pawn.getRepresentation())
        );

    }

}