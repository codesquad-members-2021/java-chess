package chess;

import org.junit.jupiter.api.*;
import piece.Piece;
import piece.attribute.*;

import java.util.*;

import static util.StringUtil.*;
import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;
    private ChessView chessView;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        chessView = new ChessView();
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
        assertThat(chessView.view(board))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("색상과 타입이 일치하는 말의 수를 반환")
    void verifyGetNumberOfPieces() {
        assertAll(() -> assertThat(board.getNumberOf(Color.WHITE, Type.PAWN)).isEqualTo(8),
                () -> assertThat(board.getNumberOf(Color.WHITE, Type.KING)).isEqualTo(1));
    }

    @Test
    @DisplayName("지정한 위치에 맞는 말을 반환")
    void verifyFindPiece() {
        Position position1 = new Position("a8");
        Position position2 = new Position("e1");
        assertAll(() -> assertThat(board.findPiece(position1))
                        .isEqualTo(createPiece(Color.BLACK, Type.ROOK, position1)),
                () -> assertThat(board.findPiece(position2))
                        .isEqualTo(createPiece(Color.WHITE, Type.KING, position2)));
    }

    @Test
    @DisplayName("말을 지정한 위치로 이동")
    void verifyMove() {
        board.initializeEmpty();
        Position before = new Position("d8");
        Position after = new Position("d5");
        Piece blackQueen = createPiece(Color.BLACK, Type.QUEEN, before);

        board.addPiece(blackQueen);
        board.move(before, after);

        assertThat(board.findPiece(after)).isEqualTo(blackQueen);
    }

    @Test
    @DisplayName("남아있는 흰색과 검은색 말의 총점을 각각 반환")
    void verifyCalculatePoint() {
        board.initializeEmpty();
        board.addPiece(createPiece(Color.BLACK, Type.PAWN, "b6"));
        board.addPiece(createPiece(Color.BLACK, Type.PAWN, "b7"));
        board.addPiece(createPiece(Color.BLACK, Type.PAWN, "b5"));
        board.addPiece(createPiece(Color.BLACK, Type.QUEEN, "e6"));
        board.addPiece(createPiece(Color.BLACK, Type.KING, "b8"));
        board.addPiece(createPiece(Color.BLACK, Type.ROOK, "c8"));

        board.addPiece(createPiece(Color.WHITE, Type.PAWN, "f2"));
        board.addPiece(createPiece(Color.WHITE, Type.PAWN, "f3"));
        board.addPiece(createPiece(Color.WHITE, Type.PAWN, "g2"));
        board.addPiece(createPiece(Color.WHITE, Type.PAWN, "h3"));
        board.addPiece(createPiece(Color.WHITE, Type.ROOK, "e1"));
        board.addPiece(createPiece(Color.WHITE, Type.KING, "f1"));

        System.out.println(chessView.view(board));
        assertAll(() -> assertThat(board.calculatePoint(Color.BLACK)).isCloseTo(15.5, within(0.01)),
                () -> assertThat(board.calculatePoint(Color.WHITE)).isCloseTo(8.0, within(0.01)));
    }

    @Test
    @DisplayName("기물의 점수가 높은 순으로 정렬된 리스트를 반환")
    void verifyGetPiecesSortedByPoint() {
        List<Piece> whitePieces = board.getPiecesSortedByPoint(Color.WHITE);
        assertThat(whitePieces.toString()).isEqualTo("[q, r, r, n, b, b, n, p, p, p, p, p, p, p, p, k]");
    }
}

