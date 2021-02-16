package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private int index = 0;

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
    @DisplayName("Board에 Pawn이 제대로 추가되는지 확인")
    void create() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        verifyAddWhitePawn(white);
        verifyAddBlackPawn(black);
    }

    void verifyAddWhitePawn(Pawn whitePawn) {
        board.addWhitePawn(whitePawn);
        assertEquals(whitePawn, board.findWhitePawn(0));
    }

    void verifyAddBlackPawn(Pawn blackPawn){
        board.addBlackPawn(blackPawn);
        assertEquals(blackPawn, board.findBlackPawn(0));
    }
}
