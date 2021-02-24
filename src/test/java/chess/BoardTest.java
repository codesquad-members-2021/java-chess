package chess;

import org.junit.jupiter.api.*;
import piece.Piece;
import piece.attribute.Color;
import piece.attribute.Type;

import java.util.Collections;
import java.util.List;

import static util.StringUtil.*;
import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화된 체스판을 출력 양식에 맞춰 반환")
    void verifyInitialize() {
        String result = new StringBuilder()
                .append("R N B Q K B N R   8").append(NEWLINE)
                .append("P P P P P P P P   7").append(NEWLINE)
                .append(". . . . . . . .   6").append(NEWLINE)
                .append(". . . . . . . .   5").append(NEWLINE)
                .append(". . . . . . . .   4").append(NEWLINE)
                .append(". . . . . . . .   3").append(NEWLINE)
                .append("p p p p p p p p   2").append(NEWLINE)
                .append("r n b q k b n r   1").append(NEWLINE)
                .append(NEWLINE).append("a b c d e f g h ").toString();
        assertThat(board.getResultToPrint())
                .isEqualTo(result);
    }

    @Test
    @DisplayName("색상과 타입이 일치하는 말의 수를 반환")
    void verifyGetNumberOfPieces() {
        assertAll(() -> assertThat(board.getNumberOfPieces(Color.WHITE, Type.PAWN)).isEqualTo(8),
                () -> assertThat(board.getNumberOfPieces(Color.WHITE, Type.KING)).isEqualTo(1));
    }

    @Test
    @DisplayName("지정한 위치에 맞는 말을 반환")
    void verifyFindPiece() {
        assertAll(() -> assertThat(board.findPiece(new Position("a8")))
                        .isEqualTo(createPiece(Color.BLACK, Type.ROOK)),
                () -> assertThat(board.findPiece(new Position("e1")))
                        .isEqualTo(createPiece(Color.WHITE, Type.KING)));
    }

    @Test
    @DisplayName("말을 지정한 위치로 이동")
    void verifyMove() {
        board.initializeEmpty();
        Position before = new Position("b6");
        Position after = new Position("d3");
        Piece blackQueen = createPiece(Color.BLACK, Type.QUEEN);

        board.addPiece(before, blackQueen);
        board.move(before, after);

        assertThat(board.findPiece(after)).isEqualTo(blackQueen);
    }

    @Test
    @DisplayName("남아있는 흰색과 검은색 말의 총점을 각각 반환")
    void verifyCalculatePoint() {
        board.initializeEmpty();
        addPiece("b6", createPiece(Color.BLACK, Type.PAWN));
        addPiece("b7", createPiece(Color.BLACK, Type.PAWN));
        addPiece("b5", createPiece(Color.BLACK, Type.PAWN));
        addPiece("e6", createPiece(Color.BLACK, Type.QUEEN));
        addPiece("b8", createPiece(Color.BLACK, Type.KING));
        addPiece("c8", createPiece(Color.BLACK, Type.ROOK));

        addPiece("f2", createPiece(Color.WHITE, Type.PAWN));
        addPiece("f3", createPiece(Color.WHITE, Type.PAWN));
        addPiece("g2", createPiece(Color.WHITE, Type.PAWN));
        addPiece("h3", createPiece(Color.WHITE, Type.PAWN));
        addPiece("e1", createPiece(Color.WHITE, Type.ROOK));
        addPiece("f1", createPiece(Color.WHITE, Type.KING));

        assertAll(() -> assertThat(board.calculatePoint(Color.BLACK)).isCloseTo(15.5, within(0.01)),
                () -> assertThat(board.calculatePoint(Color.WHITE)).isCloseTo(8.0, within(0.01)));
    }

    private void addPiece(String position, Piece piece) {
        board.addPiece(new Position(position), piece);
    }

    @Test
    @DisplayName("기물의 점수가 높은 순으로 정렬된 리스트를 반환")
    void verifyGetPiecesSortedByPoint() {
        List<Piece> whitePieces = board.getPiecesSortedByPoint(Color.WHITE);
        assertThat(whitePieces.toString()).isEqualTo("[q, r, r, n, b, b, n, p, p, p, p, p, p, p, p, k]");
    }

    @Test
    @DisplayName("역순으로도 정렬해보라는 요구사항 테스트")
    void verifyReversedOrder() {
        List<Piece> blackPieces = board.getPiecesSortedByPoint(Color.BLACK);
        blackPieces.sort(Collections.reverseOrder());
        assertThat(blackPieces.toString()).isEqualTo("[K, P, P, P, P, P, P, P, P, N, B, B, N, R, R, Q]");
    }
}

