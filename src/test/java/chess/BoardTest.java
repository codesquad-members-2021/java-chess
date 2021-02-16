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
        addPawnOnBoard(1, white);
        Pawn black = new Pawn(Color.BLACK);
        addPawnOnBoard(2, black);
    }
    
    void addPawnOnBoard(int index, Pawn pawnInstance) {
        board.add(pawnInstance);
        assertThat(index).isEqualTo(board.size());
        assertThat(pawnInstance).isEqualTo(board.findPawn(index-1));
    }
}
