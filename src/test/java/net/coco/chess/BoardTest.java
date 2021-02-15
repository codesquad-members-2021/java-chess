package net.coco.chess;


import net.coco.pieces.Pawn;
import net.coco.pieces.PawnEnum;
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
    @DisplayName("판에 폰이 잘 들어가는지 체크")
    public void BoardAddPawnCheck() {

        Assertions.assertAll(
                () -> verifyPawnToPawns(PawnEnum.WHITE_COLOR, 0),
                () -> verifyPaswsSize(PawnEnum.WHITE_COLOR, 1),

                () -> verifyPawnToPawns(PawnEnum.BLACK_COLOR, 0),
                () -> verifyPaswsSize(PawnEnum.BLACK_COLOR, 1)
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