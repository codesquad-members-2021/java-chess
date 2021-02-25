package net.kjk402.chess.chess;

import static net.kjk402.chess.utils.StringUtils.appendNewLine;

import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BoardTest {
    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("특정 위치로 기물을 요청 시에 알맞은 기물이 조회되는 지 확인한다.")
    void findPiece() {
        board.initialize();

        assertAll(
                () -> verifyPiecePosition("h8", Piece.Color.BLACK, Piece.Type.ROOK),
                () -> verifyPiecePosition("g8", Piece.Color.BLACK, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("c8", Piece.Color.BLACK, Piece.Type.BISHOP),
                () -> verifyPiecePosition("d8", Piece.Color.BLACK, Piece.Type.QUEEN),
                () -> verifyPiecePosition("e8", Piece.Color.BLACK, Piece.Type.KING),
                () -> verifyPiecePosition("f8", Piece.Color.BLACK, Piece.Type.BISHOP),
                () -> verifyPiecePosition("g8", Piece.Color.BLACK, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("h8", Piece.Color.BLACK, Piece.Type.ROOK),

                () -> verifyPiecePosition("a1", Piece.Color.WHITE, Piece.Type.ROOK),
                () -> verifyPiecePosition("b1", Piece.Color.WHITE, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("c1", Piece.Color.WHITE, Piece.Type.BISHOP),
                () -> verifyPiecePosition("d1", Piece.Color.WHITE, Piece.Type.QUEEN),
                () -> verifyPiecePosition("e1", Piece.Color.WHITE, Piece.Type.KING),
                () -> verifyPiecePosition("f1", Piece.Color.WHITE, Piece.Type.BISHOP),
                () -> verifyPiecePosition("g1", Piece.Color.WHITE, Piece.Type.KNIGHT),
                () -> verifyPiecePosition("h1", Piece.Color.WHITE, Piece.Type.ROOK)
        );
    }

    void verifyPiecePosition(String index, Piece.Color color, Piece.Type type) {
        assertAll(
                () -> assertThat(board.findPiece(index).getColor()).isEqualTo(color),
                () -> assertThat(board.findPiece(index).getType()).isEqualTo(type)
        );
    }

}
