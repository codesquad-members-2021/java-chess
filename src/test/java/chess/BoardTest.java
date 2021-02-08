package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

public class BoardTest {

    @Test
    @DisplayName("게임 보드 생성 테스트")
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

}
