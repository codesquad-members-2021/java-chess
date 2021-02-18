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
        addWhitePawnOnBoard(1, white);
        Pawn black = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        addBlackPawnOnBoard(2, black);
    }
    
    void addWhitePawnOnBoard(int index, Pawn whitePawnInstance) {
        board.whitePawnAdd(whitePawnInstance);
        assertThat(index).isEqualTo(board.whitePawnSize());
        assertThat(whitePawnInstance).isEqualTo(board.findWhitePawn(index-1));
    }

    void addBlackPawnOnBoard(int index, Pawn blackPawnInstance) {
        board.blackPawnAdd(blackPawnInstance);
        assertThat(index).isEqualTo(board.blackPawnSize());
        assertThat(blackPawnInstance).isEqualTo(board.findBlackPawn(index-1));
    }

    @Test
    @DisplayName("보드판을 초기화 합니다")
    void initialize(){
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }
}
