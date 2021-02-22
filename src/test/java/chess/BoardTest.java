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
    @DisplayName("폰 생성 횟수 체크 기능과 원하는 폰의 인덱스를 찾는 기능이 잘 되는지 테스트 한다.")
    void createPawn(){
        Pawn white = new Pawn(Pawn.WHITE);
        addWhitePawnOnBoard(1, white);
        Pawn black = new Pawn(Pawn.BLACK);
        addBlackPawnOnBoard(1, black);
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
    @DisplayName("보드판에 초기화 된 이니셜이 의도한 바와 맞는지 테스트합니다")
    void initialize(){
        board.initialize();
        assertThat(board.getWhitePawnsRepresentation()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsRepresentation()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("보드판 출력이 원하는 그림대로 나오는지 테스트")
    void printBoard(){
        board.initialize();
        assertThat(board.getBoard()).isEqualTo(
                "........\n" +
                "pppppppp\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "PPPPPPPP\n" +
                "........");
    }
}
