package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화 했을 때 Board에 흑 폰 8개 백 폰 8개가 있는지 확인")
    void initialize() {
        board.initialize();
        assertAll(
                () -> assertEquals("pppppppp", board.getWhitePawnsResult()),
                () -> assertEquals("PPPPPPPP", board.getBlackPawnsResult())
        );
    }

    @Test
    @DisplayName("초기화 했을때 Board출력이 제대로 되는지 확인")
    void print(){
        board.initialize();
        System.out.println(board.printBoard());
    }

    @Test
    @DisplayName("Board에 흰색 폰 한개와 흑색 폰 한개가 제대로 추가되는지 확인")
    void create() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        verifyAddWhitePawn(white);
        verifyAddBlackPawn(black);
        verifySize();
    }

    void verifyAddWhitePawn(Pawn whitePawn) {
        board.addWhitePawn(whitePawn);
        assertEquals(whitePawn, board.findWhitePawn(0));
    }

    void verifyAddBlackPawn(Pawn blackPawn){
        board.addBlackPawn(blackPawn);
        assertEquals(blackPawn, board.findBlackPawn(0));
    }

    void verifySize(){
        assertEquals(2,board.size());
    }
}
