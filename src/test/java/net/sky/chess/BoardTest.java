package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;
    private PieceMaker whitePieceMaker;
    private PieceMaker blackPieceMaker;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        whitePieceMaker = new PieceMaker(Color.WHITE);
        blackPieceMaker = new PieceMaker(Color.BLACK);
    }

    @Test
    @DisplayName("체스판 초기화 확인")
    void create() {
        String blankRank = appendNewLine("........");

        assertThat(board.showBoard()).isEqualTo(appendNewLine("RNBQKBNR")
            + appendNewLine("PPPPPPPP")
            + blankRank + blankRank + blankRank + blankRank
            + appendNewLine("pppppppp")
            + appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("기물의 개수 반환 테스트")
    void pieceCount() {
        Piece whitePawn = whitePieceMaker.createPawn();
        Piece whiteRook = whitePieceMaker.createRook();
        Piece whiteKnight = whitePieceMaker.createKnight();
        Piece whiteBishop = whitePieceMaker.createBishop();
        Piece whiteQueen = whitePieceMaker.createQueen();
        Piece whiteKing = whitePieceMaker.createKing();

        assertAll(
            () -> assertThat(board.pieceCount(whitePawn)).isEqualTo(8),
            () -> assertThat(board.pieceCount(whiteRook)).isEqualTo(2),
            () -> assertThat(board.pieceCount(whiteKnight)).isEqualTo(2),
            () -> assertThat(board.pieceCount(whiteBishop)).isEqualTo(2),
            () -> assertThat(board.pieceCount(whiteQueen)).isEqualTo(1),
            () -> assertThat(board.pieceCount(whiteKing)).isEqualTo(1)
        );

        Piece blackPawn = blackPieceMaker.createPawn();
        Piece blackRook = blackPieceMaker.createRook();
        Piece blackKnight = blackPieceMaker.createKnight();
        Piece blackBishop = blackPieceMaker.createBishop();
        Piece blackQueen = blackPieceMaker.createQueen();
        Piece blackKing = blackPieceMaker.createKing();

        assertAll(
            () -> assertThat(board.pieceCount(blackPawn)).isEqualTo(8),
            () -> assertThat(board.pieceCount(blackRook)).isEqualTo(2),
            () -> assertThat(board.pieceCount(blackKnight)).isEqualTo(2),
            () -> assertThat(board.pieceCount(blackBishop)).isEqualTo(2),
            () -> assertThat(board.pieceCount(blackQueen)).isEqualTo(1),
            () -> assertThat(board.pieceCount(blackKing)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("주어진 기물의 위치 확인")
    void findPiece() {
        assertAll(
            () -> assertThat(board.findPiece("a8")).isEqualTo(blackPieceMaker.createRook()),
            () -> assertThat(board.findPiece("h8")).isEqualTo(blackPieceMaker.createRook()),
            () -> assertThat(board.findPiece("a1")).isEqualTo(whitePieceMaker.createRook()),
            () -> assertThat(board.findPiece("h1")).isEqualTo(whitePieceMaker.createRook())
        );
    }
}
