package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판의 초기화가 정상적으로 이루어졌는지 확인한다.")
    void printBoard() {
        board.initialize();
        String blankRank = ". . . . . . . .";
        final int TOTAL_PIECES_COUNT = 32;

        assertAll(
                () -> assertThat(TOTAL_PIECES_COUNT).isEqualTo(board.totalPiecesCount()),
                () -> assertThat(StringUtils.addNewLine("R N B Q K B N R  8") +
                        StringUtils.addNewLine("P P P P P P P P  7") +
                        StringUtils.addNewLine(blankRank + "  6") +
                        StringUtils.addNewLine(blankRank + "  5") +
                        StringUtils.addNewLine(blankRank + "  4") +
                        StringUtils.addNewLine(blankRank + "  3") +
                        StringUtils.addNewLine("p p p p p p p p  2") +
                        StringUtils.addNewLine("r n b q k b n r  1") +
                        StringUtils.getNewLine() +
                        StringUtils.addNewLine("a b c d e f g h"))
                        .isEqualTo(board.getChessBoard())
        );
    }

    @Test
    void findPiece() {
        board.initialize();

        verifyPieceColorAndType(Color.BLACK, Type.ROOK, "a8");
        verifyPieceColorAndType(Color.BLACK, Type.ROOK, "h8");
        verifyPieceColorAndType(Color.WHITE, Type.ROOK, "a1");
        verifyPieceColorAndType(Color.WHITE, Type.ROOK, "h1");
    }

    void verifyPieceColorAndType(Color color, Type type, String index) {
        assertAll(
                () -> assertThat(type).isEqualTo(board.findPiece(index).getType()),
                () -> assertThat(color).isEqualTo(board.findPiece(index).getColor())
                );
    }

    @Test
    public void move() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPiece(position));
        System.out.println(board.getChessBoard());
    }
}
