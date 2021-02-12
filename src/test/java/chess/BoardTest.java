package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;
    private int count = 0;

    @BeforeEach
    public void createBoard() {
        board = new Board();
    }

    public void createPawnAndVerify(Color color) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        count += 1;
        assertThat(board.size()).isEqualTo(count);
        assertThat(board.findPawn(count - 1)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("흰색, 검은색 Pawn을 생성해 board에 추가한다")
    public void createPawnOnTheBoard() throws Exception {
        createPawnAndVerify(Color.WHITE);
        createPawnAndVerify(Color.BLACK);
    }
}
