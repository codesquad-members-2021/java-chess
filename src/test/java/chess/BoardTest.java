package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {
    @Test
    @DisplayName("흰색 Pawn 과 검은 색 Pawn 을 체스 판에 추가한다.")
    public void create() {
        Board board = new Board();

        Pawn whitePawn = new Pawn(Color.WHITE);
        board.add(whitePawn);
        assertThat(board.size())
                .isEqualTo(1);
        assertThat(board.findPawn(0))
                .isEqualTo(whitePawn);

        Pawn blackPawn = new Pawn(Color.BLACK);
        board.add(blackPawn);
        assertThat(board.size())
                .isEqualTo(2);
        assertThat(board.findPawn(1))
                .isEqualTo(blackPawn);
    }
}
