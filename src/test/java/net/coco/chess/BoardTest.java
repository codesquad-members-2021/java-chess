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
    void boardAddPawnCheck() {

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
                () -> assertThat(32).isEqualTo(board.getPiecesSize()),
                () -> assertThat("PPPPPPPP").isEqualTo(board.getPawnsResult(Piece.BLACK)),
                () -> assertThat("RNBQKBNR").isEqualTo(board.getOtherPiecesResult(Piece.BLACK)),
                () -> assertThat("rnbqkbnr").isEqualTo(board.getOtherPiecesResult(Piece.WHITE)),
                () -> assertThat("pppppppp").isEqualTo(board.getPawnsResult(Piece.WHITE))
        );
        PrintChess.printBoard(board);
    }

    @Test
    @DisplayName("board에 piece를 넣을 때는 piece에 따른 알맞은 메소드를 사용해야한다.")
    void addOtherPieces() {
        Piece blackBishop = Piece.createBlackBishop();
        Piece blackPawn = Piece.createBlackPawn();

        Assertions.assertAll(
                () -> board.addOtherPiece(blackBishop),
                () -> assertThat(1).isEqualTo(board.getPiecesSize()),

                () -> board.addOtherPiece(blackPawn),
                () -> assertThat(1).isEqualTo(board.getPiecesSize()),

                () -> board.addPawn(blackBishop),
                () -> assertThat(1).isEqualTo(board.getPiecesSize())
        );
    }

    @Test
    void isBlack() {
        Assertions.assertAll(
                () -> assertThat(true).isEqualTo(Piece.createBlackBishop().isBlack()),
                () -> assertThat(true).isEqualTo(Piece.createWhiteBishop().isWhite())
        );

    }


    void verifyPawnToPawns(String color, int findPawnIndex) {

        if (color.equals(Piece.WHITE))
            verifyWhitePawnsIndex(Piece.createWhitePawn(), findPawnIndex);
        else
            verifyBlackPawnsIndex(Piece.createBlackPawn(), findPawnIndex);

    }

    void verifyWhitePawnsIndex(Piece piece, int findPawnIndex) {
        board.addPawn(piece);
        assertThat(piece).isEqualTo(board.findWhitePawn(findPawnIndex));
    }

    void verifyBlackPawnsIndex(Piece piece, int findPawnIndex) {
        board.addPawn(piece);
        assertThat(piece).isEqualTo(board.findBlackPawn(findPawnIndex));
    }

    void verifyPawnsSize(int actualSize) {
        assertThat(actualSize).isEqualTo(board.getPiecesSize());
    }


}
