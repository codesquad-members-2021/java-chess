package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import pieces.Pawn;
import pieces.Color;

class BoardTest {

    Board board;

    @BeforeEach
    void createBoard(){
        board = new Board();
    }

    @Test
    @DisplayName("보드를 생성한 후 폰 테스트 한다.")
    void createPawn(){

        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        assertThat(1).isEqualTo(board.size());
        assertThat(white).isEqualTo(board.findPawn(0));

        Pawn black = new Pawn(Color.BLACK);
        board.add(black);
        assertThat(2).isEqualTo(board.size());
        assertThat(black).isEqualTo(board.findPawn(1));
    }
}
