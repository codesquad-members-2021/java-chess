package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("모든 Test 전에 Board 객체 생성")
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("WhitePawns의 값 사이즈 index로 색상 값을 잘 가져오는지 확인")
    void create_white() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        board.addWhitePawns(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);
        assertThat(board.findWhitePawn(0).getColor()).isEqualTo("white");
        assertThat(board.findWhitePawn(0).getRepresentation()).isEqualTo('p');
    }

    @Test
    @DisplayName("BlackPawns의 값 사이즈 index로 색상 값을 잘 가져오는지 확인")
    void create_black() {
        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        board.addBlackPawns(black);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
        assertThat(board.findBlackPawn(0).getColor()).isEqualTo("black");
        assertThat(board.findBlackPawn(0).getRepresentation()).isEqualTo('P');
    }

    @Test
    @DisplayName("Board에 추가되는 기물 size 값 검토")
    void check_board_size() {
        board.addWhitePawns(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
        board.addBlackPawns(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        assertThat(board.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("보드 초기화가 잘 이루어지는지 확인 예)흰색 ->pppppppp 검은색->PPPPPPPP")
    void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("보드 초기화가 잘 print 되는지 확인")
    void print() {
        board.initialize();
        assertThat(board.boardPrint()).isEqualTo("........" + System.getProperty("line.separator") +
                "PPPPPPPP" + System.getProperty("line.separator") +
                "........" + System.getProperty("line.separator") +
                "........" + System.getProperty("line.separator") +
                "........" + System.getProperty("line.separator") +
                "........" + System.getProperty("line.separator") +
                "pppppppp" + System.getProperty("line.separator") +
                "........");
    }

}
