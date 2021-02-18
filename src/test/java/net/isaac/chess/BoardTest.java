package net.isaac.chess;

import net.isaac.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import net.isaac.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("Board의 초기화 테스트")
    void initializeTest() throws Exception {
        board.initialize();
        assertAll(
                ()->assertThat(board.getWhitePiecesResult()).isEqualTo("pppppppp"),
                ()->assertThat(board.getBlackPiecesResult()).isEqualTo("PPPPPPPP")
        );
    }

    @Test
    @DisplayName("Board의 Pawn 등록 테스트")
    void pawnAddTest() throws Exception {
        Pawn white = (Pawn)Piece.getPawn(Piece.Color.WHITE);
        board.add(white, 0, 0);
        Pawn black = (Pawn)Piece.getPawn(Piece.Color.BLACK);
        board.add(black, 0, 1);

        assertAll(
                ()->assertThat(board.findPiece(0,0)).isEqualTo(white),
                ()->assertThat(board.findPiece(0,1)).isEqualTo(black),
                ()->assertThat(board.findPiece(0,2)).isEqualTo(null),
                ()->assertThat(board.findPiece(10,10)).isEqualTo(null)
        );
    }
}
