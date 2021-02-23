package net.isaac.chess;

import net.isaac.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.isaac.utils.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("Board의 초기화 테스트")
    void initializeTest() throws Exception {
        board.initialize();
        String initialBoardRepresentation = getInitialBoardRepresentation();
        assertAll(
                () -> assertThat(board.pieceCount()).isEqualTo(32),
                () -> assertThat(board.getRepresentation()).isEqualTo(initialBoardRepresentation)
        );
    }

    String getInitialBoardRepresentation() {
        String blankRank = appendNewLine("........");

        return appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");
    }

    @Test
    @DisplayName("Board의 Pawn 등록 테스트")
    void pawnAddTest() throws Exception {
        Piece white = Piece.createPawn(Piece.Color.WHITE);
        board.add(white, 0, 0);
        Piece black = Piece.createPawn(Piece.Color.BLACK);
        board.add(black, 0, 1);

        assertAll(
                () -> assertThat(board.findPiece(0, 0)).isEqualTo(white),
                () -> assertThat(board.findPiece(0, 1)).isEqualTo(black),
                () -> assertThat(board.findPiece(0, 2)).isEqualTo(null),
                () -> assertThat(board.findPiece(10, 10)).isEqualTo(null)
        );
    }
}
