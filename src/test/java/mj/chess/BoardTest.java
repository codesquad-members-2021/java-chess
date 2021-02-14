package mj.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static mj.chess.Pawn.Color.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {
    @Test
    @DisplayName("보드 객체 내 흰색 폰 1개, 검은색 폰 1개 생성")
    public void create_board() {
        Board board = new Board();

        Pawn white = new Pawn(WHITE.name());
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(white).isEqualTo(board.findPawn(0));

        Pawn black = new Pawn(BLACK.name());
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(black).isEqualTo(board.findPawn(1));
    }
}
