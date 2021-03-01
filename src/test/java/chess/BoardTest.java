package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Piece;
import pieces.Type;

import static utils.StringUtils.*;

class BoardTest {

    private Board board;
    private final String BLANK_RANK = appendNewLine("........");

    @BeforeEach
    void testInit() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("게임 보드 초기화")
    void initialize() {
        String initBoard =
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                BLANK_RANK + BLANK_RANK + BLANK_RANK + BLANK_RANK +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");

        assertThat(board.pieceCount()).as("Board Size").isEqualTo(32);
        assertThat(board.showBoard()).as("Board Initial State").isEqualTo(initBoard);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("게임 보드 내의 체스말을 종류별로 세기")
    void countPieceByColorAndType() {
        countPieceByType(Type.PAWN, 8);
        countPieceByType(Type.KNIGHT, 2);
        countPieceByType(Type.ROOK, 2);
        countPieceByType(Type.BISHOP, 2);
        countPieceByType(Type.QUEEN, 1);
        countPieceByType(Type.KING, 1);
    }

    private void countPieceByType(Type type, int count) {
        assertThat(board.countPieceByColorAndType(Color.BLACK, type)).isEqualTo(count);
        assertThat(board.countPieceByColorAndType(Color.WHITE, type)).isEqualTo(count);
    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회")
    void findPiece() {
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlackRook());
        assertThat(board.findPiece("b8")).isEqualTo(Piece.createBlackKnight());
        assertThat(board.findPiece("c8")).isEqualTo(Piece.createBlackBishop());
        assertThat(board.findPiece("d8")).isEqualTo(Piece.createBlackQueen());
        assertThat(board.findPiece("e8")).isEqualTo(Piece.createBlackKing());
        assertThat(board.findPiece("f8")).isEqualTo(Piece.createBlackBishop());
        assertThat(board.findPiece("g8")).isEqualTo(Piece.createBlackKnight());
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlackRook());

        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhiteRook());
        assertThat(board.findPiece("b1")).isEqualTo(Piece.createWhiteKnight());
        assertThat(board.findPiece("c1")).isEqualTo(Piece.createWhiteBishop());
        assertThat(board.findPiece("d1")).isEqualTo(Piece.createWhiteQueen());
        assertThat(board.findPiece("e1")).isEqualTo(Piece.createWhiteKing());
        assertThat(board.findPiece("f1")).isEqualTo(Piece.createWhiteBishop());
        assertThat(board.findPiece("g1")).isEqualTo(Piece.createWhiteKnight());
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhiteRook());
    }

    @Test
    @DisplayName("기물을 움직인 후 위치 조회")
    void move() {
        String movedBoard =
                BLANK_RANK + BLANK_RANK + BLANK_RANK +
                appendNewLine(".P......") +
                BLANK_RANK + BLANK_RANK + BLANK_RANK + BLANK_RANK;

        board.initializeEmpty();
        String position = "b5";
        Piece piece = Piece.createBlackPawn();
        board.move(position, piece);

        assertThat(piece).isEqualTo(board.findPiece(position));
        assertThat(board.showBoard()).isEqualTo(movedBoard);

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("체스 프로그램 점수 계산하기")
    void calculatePoint() {
        board.initializeEmpty();
        String currentBoard =
                appendNewLine(".KR.....") +
                appendNewLine("P.PB....") +
                appendNewLine(".P..Q...") +
                BLANK_RANK +
                appendNewLine(".....nq.") +
                appendNewLine(".....p.p") +
                appendNewLine(".....pp.") +
                appendNewLine("....rk..");

        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("a7", Piece.createBlackPawn());
        addPiece("c7", Piece.createBlackPawn());
        addPiece("d7", Piece.createBlackBishop());
        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());

        addPiece("f4", Piece.createWhiteKnight());
        addPiece("g4", Piece.createWhiteQueen());
        addPiece("f3", Piece.createWhitePawn());
        addPiece("h3", Piece.createWhitePawn());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(board.showBoard()).isEqualTo(currentBoard);
        System.out.println(board.showBoard());
        assertThat(board.calculatePoint(Color.BLACK)).isCloseTo(20.0, within(0.01));
        assertThat(board.calculatePoint(Color.WHITE)).isCloseTo(19.5, within(0.01));

    }
    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

}
