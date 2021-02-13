package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Pawn;

public class BoardTest {

    @Test
    @DisplayName("게임 보드 생성 테스트")
    public void create() throws Exception {
        Board board = new Board();
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);

        addPawnToBoard(board, white, 1);
        addPawnToBoard(board, black, 2);

    }

    public void addPawnToBoard(Board board, Pawn pawn, int size) {
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(board.findPawn(size - 1)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("게임 보드 초기화")
   public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }

}
