package cooper.chess;

import cooper.chess.piece.Color;
import cooper.chess.piece.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("board에 흰색 폰과 검정색 폰이 추가됨을 확인한다.")
    public void create() {
        Board board = new Board();

        Piece white = Piece.createWhitePawn();
        board.add(white);

        Piece black = Piece.createBlackPawn();
        board.add(black);

        assertAll(
                () -> assertEquals(1, board.size(Color.WHITE)),
                () -> {
                    assertEquals(white, board.findPawn(0, Color.WHITE));
                    assertEquals(black, board.findPawn(0, Color.BLACK));
                }
        );
    }

    @Test
    @DisplayName("board 사이즈가 0일 때의 예외를 발생시킨다.")
    public void testZeroSizeOfBoard() {
        Board board = new Board();

        assertThrows(IllegalArgumentException.class,
                () -> board.findPawn(0, Color.WHITE));
    }

    @Test
    @DisplayName("index 외에 값을 입력이 예외를 발생시킨다.")
    public void testOutOfBoardSize() {
        Board board = new Board();

        Piece white = Piece.createWhitePawn();
        board.add(white);

        Piece black = Piece.createBlackPawn();
        board.add(black);

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(-1, Color.WHITE)),
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(3, Color.BLACK))
        );
    }

    @Test
    @DisplayName("board를 초기상태를 세팅한다.")
    public void initialize() {
        Board board = new Board();
        board.initialize();
        assertAll(
                () -> assertEquals("PPPPPPPP", board.getPawnsResult(Color.WHITE)),
                () -> assertEquals("pppppppp", board.getPawnsResult(Color.BLACK))
        );
    }

    @Test
    @DisplayName("board의 상태를 확인한다.")
    public void getBoardStatusTest() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.getBoardStatus());
    }
}
