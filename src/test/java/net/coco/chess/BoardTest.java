package net.coco.chess;


import net.coco.pieces.Piece;
import net.coco.printer.PrintChess;
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
                () -> assertThat(board.getPiecesSize()).isEqualTo(32),
                () -> assertThat(board.getPawnsResult(Piece.BLACK)).isEqualTo("PPPPPPPP"),
                () -> assertThat(board.getOtherPiecesResult(Piece.BLACK)).isEqualTo("RNBQKBNR"),
                () -> assertThat(board.getOtherPiecesResult(Piece.WHITE)).isEqualTo("rnbqkbnr"),
                () -> assertThat(board.getPawnsResult(Piece.WHITE)).isEqualTo("pppppppp")
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
                () -> assertThat(board.getPiecesSize()).isEqualTo(1),

                () -> board.addOtherPiece(blackPawn),
                () -> assertThat(board.getPiecesSize()).isEqualTo(1),

                () -> board.addPawn(blackBishop),
                () -> assertThat(board.getPiecesSize()).isEqualTo(1)
        );
    }

    @Test
    void checkBlackColor() {
        assertThat(Piece.createBlackBishop().isBlack()).isTrue();
    }
    @Test
    void checkWhiteColor() {
        assertThat(Piece.createWhiteBishop().isWhite()).isTrue();
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
