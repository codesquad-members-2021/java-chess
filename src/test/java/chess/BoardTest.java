package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

import pieces.Piece;

import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판에 흰색 폰을 추가 후 갯수와 목록을 확인한다.")
    void addWhitePawn() {
        Piece whitePawn = Piece.createWhitePawn();
        board.addWhitePawn(whitePawn);
        assertThat(board.getWhitePawnsSize()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(whitePawn);
    }

    @Test
    @DisplayName("체스판에 검은색 폰을 추가 후 갯수와 목록을 확인한다.")
    void addBlackPawn() {
        Piece blackPawn = Piece.createBlackPawn();
        board.addBlackPawn(blackPawn);
        assertThat(board.getBlackPawnsSize()).isEqualTo(1);
        assertThat(board.findBlackPawn(0)).isEqualTo(blackPawn);
    }

    @Test
    @DisplayName("체스판 전체 상태 테스트")
    void print() {
        board.initialize();
        assertThat(32).isEqualTo(board.pieceCount());
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
            appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("addWhitePawn()에 검은색 Pawn 추가")
    void addBlackToAddWhitePawn() {
        Piece blackPawn = Piece.createBlackPawn();
        boolean result = board.addWhitePawn(blackPawn);
        assertThat(result).isEqualTo(false);
    }
}
