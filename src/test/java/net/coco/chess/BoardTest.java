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

    @Test
    @DisplayName("Board size check")
    public void create() {

        Assertions.assertAll(
                () -> verifyPawnToPawns(Pawn.WHITE_COLOR, 0),
                () -> verifyPaswsSize(1),

                () -> verifyPawnToPawns(Pawn.BLACK_COLOR, 1),
                () -> verifyPaswsSize(2)
        );

    }

    private void verifyPawnToPawns(final String color, int findPawnIndex) {
        Pawn pawn = new Pawn(color);
        board.addPawn(pawn);
        assertThat(pawn).isEqualTo(board.findPawn(findPawnIndex));
    }

    private void verifyPaswsSize(int actualSize) {
        assertThat(actualSize).isEqualTo(board.size());
    }

}