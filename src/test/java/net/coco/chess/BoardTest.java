package net.coco.chess;


import net.coco.Printer.PrintChess;
import net.coco.pieces.Piece;
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

        PrintChess.printBoard(board);
    }

    private void verifyPawnToPawns(PawnEnum pawnEnum, int findPawnIndex) {
        Piece piece = new Piece(pawnEnum);

        if (pawnEnum == PawnEnum.WHITE)
            verifyWhitePawnsIndex(piece, findPawnIndex);
        else
            verifyBlackPawnsIndex(piece, findPawnIndex);

    }

    private void verifyWhitePawnsIndex(Piece piece, int findPawnIndex) {
        board.addPawn(piece);
        assertThat(piece).isEqualTo(board.findWhitePawn(findPawnIndex));
    }

    private void verifyBlackPawnsIndex(Piece piece, int findPawnIndex) {
        board.addPawn(piece);
        assertThat(piece).isEqualTo(board.findBlackPawn(findPawnIndex));
    }

    private void verifyPawnsSize(int actualSize) {
        assertThat(actualSize).isEqualTo(board.getPawnsSize());
    }


}
