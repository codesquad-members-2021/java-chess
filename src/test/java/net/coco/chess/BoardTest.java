package net.coco.chess;


import net.coco.Printer.PrintChess;
import net.coco.pieces.Piece;
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
                () -> verifyPawnToPawns(Piece.WHITE, 0),
                () -> verifyPawnsSize(1),

                () -> verifyPawnToPawns(Piece.BLACK, 0),
                () -> verifyPawnsSize(2)
        );

    }

    @Test
    void initialize() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat("PPPPPPPP").isEqualTo(board.getPawnsResult(Piece.BLACK)),
                () -> assertThat("RNBQKBNR").isEqualTo(board.getOtherPiecesResult(Piece.BLACK)),
                () -> assertThat("rnbqkbnr").isEqualTo(board.getOtherPiecesResult(Piece.WHITE)),
                () -> assertThat("pppppppp").isEqualTo(board.getPawnsResult(Piece.WHITE))
        );
    }

    @Test
    @DisplayName("addOtherPiece 아규먼트에 pawn을 넣으면 들어가지 않는다.")
    void addOtherPieces() {
        Piece blackBishop = Piece.createBlackBishop();
        Piece blackPawn = Piece.createBlackPawn();

        Assertions.assertAll(
                () -> board.addOtherPiece(blackBishop),
                () -> assertThat(1).isEqualTo(board.getPiecesSize()),

                () -> board.addOtherPiece(blackPawn),
                () -> assertThat(1).isEqualTo(board.getPiecesSize())
        );
    }

    @Test
    void print() {
        board.initialize();

        PrintChess.printBoard(board);
    }

    private void verifyPawnToPawns(String color, int findPawnIndex) {

        if (color.equals(Piece.WHITE))
            verifyWhitePawnsIndex(Piece.createWhitePawn(), findPawnIndex);
        else
            verifyBlackPawnsIndex(Piece.createBlackPawn(), findPawnIndex);

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
        assertThat(actualSize).isEqualTo(board.getPiecesSize());
    }


}
