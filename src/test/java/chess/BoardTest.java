package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class BoardTest {
    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    private void addPawnOnTheBoardAndVerify(Pawn pawn, int number, int index) {
        board.add(pawn);
        assertAll(
                () -> assertThat(board.size()).isEqualTo(number),
                () -> assertThat(board.findPawn(index)).isEqualTo(pawn)
        );
    }

    @Test
    @DisplayName("흰색, 검은색 Pawn을 생성해 board에 추가한다")
    void createPawnOnTheBoard() {
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);
        addPawnOnTheBoardAndVerify(white, 1, 0);
        addPawnOnTheBoardAndVerify(black, 2, 1);
    }
}
