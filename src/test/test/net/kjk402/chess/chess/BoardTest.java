package net.kjk402.chess.chess;

import static net.kjk402.chess.utils.StringUtils.appendNewLine;

import net.kjk402.chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class BoardTest {
    private Board board;
    private static final int ALL_PIECES = 32;
    private static final String BLACK_PIECES = "RNBQKBNR";
    private static final String BLACK_PAWNS = "PPPPPPPP";
    private static final String WHITE_PAWNS = "pppppppp";
    private static final String WHITE_PIECES = "rnbqkbnr";

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("모든 기물들을 보드에 생성 후 상태를 볼 수 있다.")
    void create_complete_board() {
        board.initialize();
        assertThat(ALL_PIECES).isEqualTo(board.pieceCount());
        String blankRank = appendNewLine("........");
        assertThat(
                appendNewLine(BLACK_PIECES) +
                        appendNewLine(BLACK_PAWNS) +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine(WHITE_PAWNS) +
                        appendNewLine(WHITE_PIECES))
                .isEqualTo(board.showBoard());
    }

    @Test
    @DisplayName("addWhitePawn 메서드를 사용하여 pawn 리스트에 piece와 pawn을 넣어본다.")
    void create_piece_at_pawnList() {
        Piece knight = new Piece(Piece.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        Piece whitePawn = new Piece(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        board.addWhitePawn(knight);
        board.addWhitePawn(whitePawn);
        assertAll(
                () -> assertThat(1).isEqualTo(board.pieceCount()),
                () -> assertThat(Piece.WHITE).isEqualTo(board.findWhitePawn(0).getColor()),
                () -> assertThat(Piece.WHITE_PAWN_REPRESENTATION).isEqualTo(board.findWhitePawn(0).getRepresentation())
        );
    }

    @Test
    @DisplayName("addWhitepiece 메서드를 사용하여 piece 리스트에 piece와 pawn을 넣어본다.")
    void create_pwan_at_pieceList() {
        Piece knight = new Piece(Piece.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
        Piece whitePawn = new Piece(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        board.addWhitePiece(knight);
        board.addWhitePiece(whitePawn);
        assertAll(
                () -> assertThat(1).isEqualTo(board.pieceCount()),
                () -> assertThat(Piece.WHITE).isEqualTo(board.findWhitePiece(0).getColor()),
                () -> assertThat(Piece.WHITE_KNIGHT_REPRESENTATION).isEqualTo(board.findWhitePiece(0).getRepresentation())
        );
    }

}
