package net.coco.pieces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class pawnTest {

    @Test
    @DisplayName("Pawn Color Test")
    public void create(){
        verifyPawn("white");
        verifyPawn("black");
    }

    public void verifyPawn(final String color){
        Pawn pawn=new Pawn(color);
        Assertions.assertThat(color).isEqualTo(pawn.getColor());

    }
}