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
        int initialPiecesCount = 32;
        assertAll(
                () -> assertThat(board.pieceCount()).isEqualTo(initialPiecesCount),
                () -> assertThat(board.getRepresentation()).isEqualTo(initialBoardRepresentation)
        );
    }

    String getInitialBoardRepresentation() {
        String blankRank = appendNewLine("........");

        return appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank +
                blankRank +
                blankRank +
                blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");
    }

    @Test
    @DisplayName("Board의 Pawn 등록 테스트")
    void pawnAddTest() throws Exception {
        Piece white = Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN);
        board.add(white, 1, 'a');
        Piece black = Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN);
        board.add(black, 1, 'b');

        assertAll(
                () -> assertThat(board.findPiece(1, 'a')).isEqualTo(white),
                () -> assertThat(board.findPiece(1, 'b')).isEqualTo(black),
                () -> assertThat(board.findPiece(1, 'c')).isNotNull(),
                () -> assertThat(board.findPiece(10, 'z')).isEqualTo(null)
        );
    }

    @Test
    @DisplayName("Board의 특정 체스말 개수 반환 테스트")
    void specificPieceCount() {
        assertAll(
                () -> assertThat(board.pieceCount(Piece.Color.BLACK, Piece.Type.PAWN)).isEqualTo(8),
                () -> assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.PAWN)).isEqualTo(8),
                () -> assertThat(board.pieceCount(Piece.Color.BLACK, Piece.Type.KNIGHT)).isEqualTo(2),
                () -> assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.KING)).isEqualTo(1)
        );
    }
}
