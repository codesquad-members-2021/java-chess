package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import pieces.Pawn;
import pieces.Piece;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
    }

    @Test
    @DisplayName("폰을 추가 시 전체 사이즈와 해당 인덱스의 폰이 일치해야 한다.")
    public void create()  {
        verifyPawnSize(Piece.PAWN_WHITE.color, Piece.PAWN_WHITE.representation, 1, 0);
        verifyPawnSize(Piece.PAWN_WHITE.color, Piece.PAWN_WHITE.representation, 2, 1);
        verifyPawnSize(Piece.PAWN_BLACK.color, Piece.PAWN_BLACK.representation, 1, 0);
        verifyPawnSize(Piece.PAWN_BLACK.color, Piece.PAWN_BLACK.representation, 2, 1);
    }

    public void verifyPawnSize(final String color, final char representation ,int size, int index) {
        Pawn pawn = new Pawn(color, representation);
        board.addPawn(color, pawn);
        assertThat(board.pawnSize(color)).isEqualTo(size);
        assertThat(board.findPawn(color, index)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("보드를 초기화한 결과 흰색 폰과 검은색 폰의 열이 각각 일치해 한다.")
    public void initialize()  {
        board.initialize();
        assertThat(board.getPawnsResult(Piece.PAWN_WHITE.color)).isEqualTo("pppppppp");
        assertThat(board.getPawnsResult(Piece.PAWN_BLACK.color)).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("초기화 된 보드가 출력되어야 한다.")
    public void print() {
        board.initialize();
        System.out.println(board.print());
    }

}
