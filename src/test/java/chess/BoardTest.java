package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // 기본 원칙은 테스트 메서드마다 테스트 인스턴스를 새로 만드는데, 명시적으로 클래스당 인스턴스 하나만 만들어서 공유할 수 있다.
public class BoardTest {

    Board board;
    int index = 0;
    int size = 0;

    @BeforeEach
    void initialize_board() {
        board = new Board();
    }

//    @DisplayName("체스판에 pawn을 넣어보기")
//    @ParameterizedTest(name = "{index} pawn color={0}")
//    @ValueSource(strings = {Pawn.WHITE_COLOR, Pawn.BLACK_COLOR})           // 배열의 크기만큼, 배열의 값들을 파라미터로 테스트를 반복한다.
//    void add_pawn_to_board(@ConvertWith(PawnConverter.class) Pawn pawn) {  // 문자열 color로 Pawn 인스턴스를 생성한 후 인자로 받는다.
//        board.add(pawn);
//
//        assertAll(
//                () -> assertEquals(++size, board.size()),                  // board에 pawn이 추가되었으므로 size를 먼저 1 증가시킨 후에 연산한다.
//                () -> assertEquals(pawn, board.findPawn(index++))          // index는 0부터 시작하므로 먼저 연산한 후에 1 증가시킨다.
//        );
//    }
//
//    /* 문자열 color로 Pawn 인스턴스로 변환해주는 클래스 */
//    static class PawnConverter extends SimpleArgumentConverter {
//
//        @Override
//        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
//            assertEquals(Pawn.class, targetType, "Can only convert to Pawn");
//            return new Pawn(source.toString());
//        }
//    }

    @Test
    void test_print() {
        String[][] initializedBoard = board.initialize();
        String chessBoard = board.print(initializedBoard);
        System.out.println(chessBoard);
    }

    @Test
    void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}
