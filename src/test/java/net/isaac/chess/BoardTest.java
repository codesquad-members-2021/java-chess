package net.isaac.chess;

import net.isaac.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
        board.add(white, "a1");
        Piece black = Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN);
        board.add(black, "b1");

        assertAll(
                () -> assertThat(board.findPiece("a1")).isEqualTo(white),
                () -> assertThat(board.findPiece("b1")).isEqualTo(black),
                () -> assertThat(board.findPiece("c1")).isNotNull(),
                () -> assertThat(board.findPiece("z10")).isEqualTo(null)
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

    @Test
    @DisplayName("색깔 별 남아 있는 체스말에 따른 점수 계산 테스트")
    void calcuatePoint() {
        board.initializeEmpty();

        board.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN), "b6");
        board.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.QUEEN), "e6");
        board.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.KING), "b8");
        board.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.ROOK), "c8");

        board.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN), "f2");
        board.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN), "g2");
        board.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK), "e1");
        board.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KING), "f1");

        assertEquals(15.0, board.calculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Piece.Color.WHITE), 0.01);

        System.out.println(board.getRepresentation());
    }

    @Test
    @DisplayName("점수로 정렬된 List<Piece>를 반환하는지 테스트")
    void getSortedPieces() {
        List<Piece> blackSortedPiecesAscending = initialAscendingSortedPieces(Piece.Color.BLACK);
        List<Piece> blackSortedPiecesDescending = initialDescendingSortedPieces(Piece.Color.BLACK);
        List<Piece> whiteSortedPiecesAscending = initialAscendingSortedPieces(Piece.Color.WHITE);
        List<Piece> whiteSortedPiecesDescending = initialDescendingSortedPieces(Piece.Color.WHITE);

        assertAll(
                () -> assertThat(board.getSortedPieces(Piece.Color.BLACK, SortOrder.ASCENDING)).isEqualTo(blackSortedPiecesAscending),
                () -> assertThat(board.getSortedPieces(Piece.Color.BLACK, SortOrder.DESCENDING)).isEqualTo(blackSortedPiecesDescending),
                () -> assertThat(board.getSortedPieces(Piece.Color.WHITE, SortOrder.ASCENDING)).isEqualTo(whiteSortedPiecesAscending),
                () -> assertThat(board.getSortedPieces(Piece.Color.WHITE, SortOrder.DESCENDING)).isEqualTo(whiteSortedPiecesDescending)
        );
    }

    List<Piece> initialAscendingSortedPieces(Piece.Color color) {
        List<Piece> sortedPieces = new ArrayList<>();

        sortedPieces.add(Piece.createPiece(color, Piece.Type.KING));
        int pawnNum = 8;
        for (int num = 0; num < pawnNum; num++) {
            sortedPieces.add(Piece.createPiece(color, Piece.Type.PAWN));
        }
        sortedPieces.add(Piece.createPiece(color, Piece.Type.KNIGHT));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.KNIGHT));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.BISHOP));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.BISHOP));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.ROOK));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.ROOK));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.QUEEN));

        return sortedPieces;
    }

    List<Piece> initialDescendingSortedPieces(Piece.Color color) {
        List<Piece> sortedPieces = new ArrayList<>();

        sortedPieces.add(Piece.createPiece(color, Piece.Type.QUEEN));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.ROOK));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.ROOK));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.BISHOP));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.BISHOP));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.KNIGHT));
        sortedPieces.add(Piece.createPiece(color, Piece.Type.KNIGHT));
        int pawnNum = 8;
        for (int num = 0; num < pawnNum; num++) {
            sortedPieces.add(Piece.createPiece(color, Piece.Type.PAWN));
        }
        sortedPieces.add(Piece.createPiece(color, Piece.Type.KING));

        return sortedPieces;
    }
}
