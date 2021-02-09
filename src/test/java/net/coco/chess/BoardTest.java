package net.coco.chess;


import net.coco.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void makeBoard() {
        board = new Board();
    }

    private void verifyPawnToPawns(final String color,int findPawnIndex) {
        Pawn pawn = new Pawn(color);
        board.addPawn(pawn);
        assertThat(pawn).isEqualTo(board.findPawn(findPawnIndex));
    }

}