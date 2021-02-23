package net.nas.chess;

import net.nas.pieces.ChessPiece;
import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.NameOfChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static net.nas.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {
    private Board board;
    private static final String INITIAL_STATE_OF_BOARD =
            appendNewLine("RNBKQBNR") +
                    appendNewLine("PPPPPPPP") +
                    appendNewLine("........") +
                    appendNewLine("........") +
                    appendNewLine("........") +
                    appendNewLine("........") +
                    appendNewLine("pppppppp") +
                    appendNewLine("rnbqkbnr");
    private static final int INITIAL_SIZE_OF_BOARD = 32;

    @BeforeEach
    void createTestBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드에 체스말을 추가하고, 찾을 수 있어야 합니다.")
    void testAdditionAndFind() {
        ChessPiece whitePawn = ChessPiece.createWhitePawn();
        for (int i = 0; i < Board.LENGTH_OF_BOARD; i++) {
            final int fileIdx = i;
            assertAll(
                    () -> verifyAddition(whitePawn, Board.RANK_OF_WHITE_PAWNS, fileIdx),
                    () -> verifyFind(whitePawn, Board.RANK_OF_WHITE_PAWNS, fileIdx)
            );
        }
    }

    @Test
    @DisplayName("문자열 좌표를 이용해서 체스판에 말을 추가할 수 있어야 합니다")
    void testAdditionWithStringCoordinate() {
        for (int i = 0; i < Board.LENGTH_OF_BOARD; i++) {
            for (int j = 0; j < Board.LENGTH_OF_BOARD; j++) {
                ChessPiece testPiece = ChessPiece.createBlackKing();
                String testCoordinate = String.format("%c%d", ('a' + j), (i + 1));
                board.add(testPiece, testCoordinate);
                assertThat(board.findPiece(i, j)).isEqualTo(testPiece);
            }
        }
    }

    private void verifyAddition(ChessPiece chessPiece, int rankIdx, int fileIdx) {
        int prevSize = board.size();
        board.add(chessPiece, rankIdx, fileIdx);
        assertThat(board.size()).isEqualTo(prevSize + 1);
    }

    private void verifyFind(ChessPiece chessPiece, int rankIdx, int fileIdx) {
        assertThat(board.findPiece(rankIdx, fileIdx)).isEqualTo(chessPiece);
    }

    @Test
    @DisplayName("폰을 찾을때 넣는 인덱스가 배열의 범위를 벗어나면 예외가 발생해야 합니다")
    void testErrorFind() {
        int[] testcases = {-1, Board.LENGTH_OF_BOARD};
        for (int tc : testcases)
            testFindThrowException(tc, tc, InvalidParameterException.class);
    }

    private void testFindThrowException(int rankIdx, int fileIdx, Class<?> exceptionClass) {
        assertThatThrownBy(() -> board.findPiece(rankIdx, fileIdx))
                .isInstanceOf(exceptionClass);
    }

    @Test
    @DisplayName("Pawn 이외의 객체가 추가되어선 안됩니다.")
    void testErrorAddition() {
        Object[] testcases = {
                new Object(),
                7,
                "Error"
        };
        for (Object tc : testcases)
            testAdditionThrowException(tc, ClassCastException.class);
        testAdditionThrowException(null, InvalidParameterException.class);
        assertThat(board.size()).isEqualTo(0);
    }

    private void testAdditionThrowException(Object tc, Class<?> exceptionClass) {
        assertThatThrownBy(() -> board.add((ChessPiece) tc, 1, 1))
                .isInstanceOf(exceptionClass);
    }

    @Test
    @DisplayName("초기화 후에는 흰색폰과 검정색폰이 각각 랭크 2, 7에 한줄씩 배치되어야 합니다.")
    void testInitialization() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
        assertThat(board.size()).isEqualTo(INITIAL_SIZE_OF_BOARD);
    }

    @Test
    @DisplayName("체스보드에서 폰만 초기화하고 나서, 적절한 결과를 획득할 수 있어야 합니다")
    void testPrintBoard() {
        board.initialize();
        assertThat(board.getRepresentationOfBoard()).isEqualTo(INITIAL_STATE_OF_BOARD);
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환할 수 있어야 합니다")
    void testGetNumberOfDesignatedPiece() {
        initTestCase();
        assertAll(
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.PAWN, ColorOfChessPiece.BLACK)).isEqualTo(3),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.KING, ColorOfChessPiece.BLACK)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.KING, ColorOfChessPiece.BLACK)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.KING, ColorOfChessPiece.WHITE)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.QUEEN, ColorOfChessPiece.BLACK)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.QUEEN, ColorOfChessPiece.WHITE)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.PAWN, ColorOfChessPiece.WHITE)).isEqualTo(2),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.BISHOP, ColorOfChessPiece.BLACK)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.ROOK, ColorOfChessPiece.BLACK)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.ROOK, ColorOfChessPiece.WHITE)).isEqualTo(1),
                () -> assertThat(board.getNumberOfDesignatedPiece(NameOfChessPiece.KNIGHT, ColorOfChessPiece.WHITE)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("체스좌표로 체스말을 획득할 수 있어야 합니다.")
    void testGetPieceByCoordinates() {
        initTestCase();
        assertAll(
                () -> testGetPieceByCoordinate("e1", NameOfChessPiece.ROOK, ColorOfChessPiece.WHITE),
                () -> testGetPieceByCoordinate("f1", NameOfChessPiece.KING, ColorOfChessPiece.WHITE),
                () -> testGetPieceByCoordinate("b6", NameOfChessPiece.PAWN, ColorOfChessPiece.BLACK),
                () -> testGetPieceByCoordinate("c8", NameOfChessPiece.ROOK, ColorOfChessPiece.BLACK)
        );
    }

    private void testGetPieceByCoordinate(String strCoordinate, NameOfChessPiece name, ColorOfChessPiece color) {
        assertThat(board.findPiece(strCoordinate).getRepresentation())
                .isEqualTo(color.getRepresentationByColor(name));
    }

    private void initTestCase() {
        String[] testcase = {
                ".KR.....",
                "P.PB....",
                ".P..Q...",
                "........",
                ".....nq.",
                ".....p..",
                "......p.",
                "....rk..",
        };
        board.initBoardByStringArray(testcase);
    }

    @Test
    @DisplayName("체스판의 상태를 점수로 표현할 수 있어야 합니다.")
    void testCalculatePoint() {
        String[] testcase = {
                ".KR.....",
                "P.PB....",
                ".P..Q...",
                "........",
                ".....nq.",
                ".....p.p",
                ".....pp.",
                "....rk.."
        };
        board.initBoardByStringArray(testcase);
        assertThat(board.calculatePoint(ColorOfChessPiece.WHITE)).isEqualTo(19.5f);
        assertThat(board.calculatePoint(ColorOfChessPiece.BLACK)).isEqualTo(20.0f);
    }

    @Test
    @DisplayName("지정된 색상에 해당하는 모든 체스말을 점수로 정렬하고 컬렉션에 담아 리턴할 수 있어야 합니다.")
    void testGetPiecesOfColor() {
        assertAll(
                () -> tryGetPiecesOfColor(ColorOfChessPiece.WHITE, true),
                () -> tryGetPiecesOfColor(ColorOfChessPiece.WHITE, false),
                () -> tryGetPiecesOfColor(ColorOfChessPiece.BLACK, true),
                () -> tryGetPiecesOfColor(ColorOfChessPiece.BLACK, false)
        );
    }

    private List<Float> initTestGetPiecesOfColor(ColorOfChessPiece color, boolean isAsc) {
        List<ChessPiece> whitePieceList = new ArrayList<>();
        List<Float> expectedResult = new ArrayList<>();

        for (NameOfChessPiece name : NameOfChessPiece.values()) {
            if (name.equals(NameOfChessPiece.NO_PIECE)) {
                continue;
            }
            whitePieceList.add(ChessPiece.createChessPiece(name, color));
            expectedResult.add(name.getPoint());
        }

        board.add(whitePieceList.get(0), "a1");
        board.add(whitePieceList.get(1), "b1");
        board.add(whitePieceList.get(2), "c7");
        board.add(whitePieceList.get(3), "d7");
        board.add(whitePieceList.get(4), "e7");
        board.add(whitePieceList.get(5), "f7");
        if (isAsc) {
            expectedResult.sort(Float::compare);
        } else {
            expectedResult.sort((Comparator.reverseOrder()));
        }
        return expectedResult;
    }

    private void tryGetPiecesOfColor(ColorOfChessPiece color, boolean isAsc) {
        List<Float> expectedResult = initTestGetPiecesOfColor(color, isAsc);
        List<ChessPiece> actualPieceList = board.getPiecesOfColor(color, isAsc);

        for (int i = 0; i < NameOfChessPiece.values().length - 1; i++) {
            float actual = actualPieceList.get(i).getNameOfChessPiece().getPoint();
            float expected = expectedResult.get(i);
            assertThat(actual).isEqualTo(expected);
        }
    }

}
