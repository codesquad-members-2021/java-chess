package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import static net.eno.utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("초기화 된 보드의 기물의 개수가 32개여야 한다.")
    public void size() {
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("타입 별 기물의 개수가 일치해야 한다.")
    public void count() {
        for (PieceType pieceType : PieceType.values()) {
            assertThat(board.targetPieceCount(pieceType)).isEqualTo(pieceCount(pieceType));
        }
    }

    private int pieceCount(PieceType pieceType) {
        switch (pieceType) {
            case NO_PIECE :
                return 32;
            case WHITE_PAWN : case BLACK_PAWN :
                return 8;
            case WHITE_KING : case BLACK_KING : case WHITE_QUEEN : case BLACK_QUEEN :
                return 1;
            default :
                return 2;
        }
    }

    @Test
    @DisplayName("체스판에 해당하는 좌표의 기물을 가져올 수 있어야 한다.")
    public void findPiece() {
        assertThat(Piece.createPiece(PieceType.BLACK_ROOK)).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createPiece(PieceType.BLACK_ROOK)).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createPiece(PieceType.WHITE_ROOK)).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createPiece(PieceType.WHITE_ROOK)).isEqualTo(board.findPiece("h1"));
    }

    @Test
    @DisplayName("초기화 된 보드의 기물의 배치가 일치해야 한다.")
    public void initialize() {
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard("white")).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        );

        assertThat(board.showBoard("black")).isEqualTo(
                appendNewLine("rnbkqbnr") +
                appendNewLine("pppppppp") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("PPPPPPPP") +
                appendNewLine("RNBKQBNR")
        );
    }

    @Test
    @DisplayName("초기화 된 보드가 출력되어야 한다.")
    public void print() {
        System.out.println(board.showBoard("white"));
        System.out.println();
        System.out.println(board.showBoard("black"));
    }

}
