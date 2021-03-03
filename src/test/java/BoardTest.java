import net.sanhee.chess.Board;
import net.sanhee.pieces.Piece;
import net.sanhee.pieces.property.UnitColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.sanhee.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private int totalPawnCnt;
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        totalPawnCnt = 0;
    }

    @Test
    @DisplayName("[체스판 상태 테스트] 1.기물 총 개수 32개? 2.모든 기물 올바른 위치에 생성?")
    void create() {
        board.initialize();
        String blankRank = appendNewLine("........");

        assertThat(board.pieceCount()).isEqualTo(32);
        assertThat(board.showBoard(0, 1).toString())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank +
                        blankRank +
                        blankRank +
                        blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("[테스트] 체스 판에 Pawn 추가 및 유효성 검사")
    void createPawn() {
        Piece whitePawn = spawnPawn(board, UnitColor.WHITE);
        Piece blackPawn = spawnPawn(board, UnitColor.BLACK);

        //m 실제 스폰된 폰의 개수와 add 개수가 맞는지 검사하는 메소드
        pawnSizeCheck(board);

        //m 입력 idx에 pawn이 스폰되있는지 검사하는 메소드
        pawnLocationCheck(board, whitePawn, 0);
        pawnLocationCheck(board, blackPawn, 1);
    }

    Piece spawnPawn(Board board, UnitColor unitColor) {
        Piece pawn = Piece.createPawn(unitColor);
        board.add(pawn);
        totalPawnCnt++;

        return pawn;
    }

    void pawnSizeCheck(Board board) {
        assertThat(board.size()).isEqualTo(totalPawnCnt);
    }

    void pawnLocationCheck(Board board, Piece pawn, int idx) {
        assertThat(board.findPiece(idx)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("[테스트] 생성된 흰색/검은색 Pawn 열의 결과 검증")
    void initialize() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("체스판 결과 출력")
    public void print() {
        board.initialize();
        System.out.println(board.showBoard(0, 1).toString());
    }
}