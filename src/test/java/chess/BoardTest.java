package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board board;

    @BeforeEach
    void initialize_board() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 생성")
    void create() throws Exception {
        Pawn white = Pawn.newWhitePawn();
        board.addWhitePawn(white);

        assertAll(
                () -> assertEquals(1, board.size()),
                () -> assertEquals(white, board.findWhitePawn(0))
        );

        Pawn black = Pawn.newBlackPawn();
        board.addBlackPawn(black);

        assertAll(
                () -> assertEquals(2, board.size()),
                () -> assertEquals(black, board.findBlackPawn(0))
        );
    }

    @Test
    @DisplayName("초기 체스판 출력")
    void test_print() {
        board.initialize();
        String chessBoard = board.print();
        System.out.println(chessBoard);
    }

    @Test
    @DisplayName("board에 흰색, 검은색 pawn 저장되어 있는지 확인")
    void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}
