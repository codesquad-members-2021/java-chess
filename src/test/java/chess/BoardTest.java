package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import pieces.Pawn;

class BoardTest {

    Board board;

    @BeforeEach
    void createBoard(){
        board = new Board();
    }

    @Test
    @DisplayName("보드를 생성한 후 폰 테스트 한다.")
    void createPawn(){
        Pawn white = new Pawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
        addPawnOnBoard(1, white);
        Pawn black = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        addPawnOnBoard(2, black);
    }
    
    void addPawnOnBoard(int index, Pawn pawnInstance) {
        board.add(pawnInstance);
        assertThat(index).isEqualTo(board.size());
        assertThat(pawnInstance).isEqualTo(board.findPawn(index-1));
    }

    @Test
    @DisplayName("보드판을 초기화 합니다")
    void initialize(){
        board.initialize();
    }
}
