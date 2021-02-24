package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

import pieces.Piece;

class BoardTest {
    Board board;

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판에 흰색 폰을 추가 후 갯수와 목록을 확인한다.")
    void putWhitePawn() {
        Piece whitePawn = Piece.createWhitePawn();
        board.addWhitePawn(whitePawn);
        assertThat(board.getWhitePawnsSize()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(whitePawn);
    }

    @Test
    @DisplayName("체스판에 검은색 폰을 추가 후 갯수와 목록을 확인한다.")
    void putBlackPawn() {
        Piece blackPawn = Piece.createBlackPawn();
        board.addBlackPawn(blackPawn);
        assertThat(board.getBlackPawnsSize()).isEqualTo(1);
        assertThat(board.findBlackPawn(0)).isEqualTo(blackPawn);
    }

    @Test
    @DisplayName("폰 이외의 객체를 추가하면 컴파일 에러가 발생한다")
    void putOther() {
        int num7 = new Integer(7);
        //board.add(num7);
    }

    @Test
    @DisplayName("체스판에 흰색, 검은색 폰을 추가 후 결과를 확인한다.")
    void initialize() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("체스판 출력")
    void print () {
        board.initialize();
        board.showBoard();
    }

    @Test
    @DisplayName("addWhitePawn()에 검은색 Pawn 추가")
    void addBlackToWhiteAdder() {
        Piece blackPawn = Piece.createBlackPawn();
        boolean result = board.addWhitePawn(blackPawn);
        assertThat(result).isEqualTo(false);
    }
}
