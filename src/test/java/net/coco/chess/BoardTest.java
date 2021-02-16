package net.coco.chess;


import net.coco.Printer.PrintChess;
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
    void makeBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("판에 폰이 잘 들어가는지 체크")
    void BoardAddPawnCheck() {

        Assertions.assertAll(
                () -> verifyPawnToPawns(PawnEnum.WHITE, 0),
                () -> verifyPawnsSize(1),

                () -> verifyPawnToPawns(PawnEnum.BLACK, 0),
                () -> verifyPawnsSize(2)
        );

    }

    @Test
    void initialize() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat("pppppppp").isEqualTo(board.getPawnsResult(PawnEnum.WHITE)),
                () -> assertThat("PPPPPPPP").isEqualTo(board.getPawnsResult(PawnEnum.BLACK))
        );
    }

    @Test
    void print() {
        board.initialize();
        String blackPawns = board.getPawnsResult(PawnEnum.BLACK);
        String whitePawns = board.getPawnsResult(PawnEnum.WHITE);
        System.out.println(PrintChess.printBoard(blackPawns, whitePawns));
    }

    private void verifyPawnToPawns(PawnEnum pawnEnum, int findPawnIndex) {
        Pawn pawn = new Pawn(pawnEnum);

        if (pawnEnum == PawnEnum.WHITE)
            verifyWhitePawnsIndex(findPawnIndex, pawn);
        else
            verifyBlackPawnsIndex(findPawnIndex, pawn);

    }

    private void verifyWhitePawnsIndex(int findPawnIndex, Pawn pawn) {
        board.addWhitePawn(pawn);
        assertThat(pawn).isEqualTo(board.findWhitePawn(findPawnIndex));
    }

    private void verifyBlackPawnsIndex(int findPawnIndex, Pawn pawn) {
        board.addBlackPawn(pawn);
        assertThat(pawn).isEqualTo(board.findBlackPawn(findPawnIndex));
    }

    private void verifyPawnsSize(int actualSize) {
        assertThat(actualSize).isEqualTo(board.getPawnsSize());
    }


}
