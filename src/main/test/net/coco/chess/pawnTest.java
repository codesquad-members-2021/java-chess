package net.coco.chess;

import net.coco.chess.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class pawnTest {

    @Test
    @DisplayName("Pawn Color Test")
    public void create(){
        verifyPawn("white");
        verifyPawn("black");
    }

    public void verifyPawn(final String color){
        Pawn pawn=new Pawn(color);
        Assertions.assertEquals(color,pawn.getColor());

    }
}