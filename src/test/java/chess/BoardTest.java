package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static chess.pieces.Piece.Color.BLACK;
import static chess.pieces.Piece.Color.WHITE;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("초기 체스판 생성")
    void create_initial_chess_board() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("인자로 받은 color와 type을 동시에 만족하는 piece의 개수를 확인한다.")
    void count_piece_with_color_and_type() {
        board.initialize();

        assertThat(board.pieceCountOf(BLACK, BISHOP)).isEqualTo(2);
        assertThat(board.pieceCountOf(BLACK, QUEEN)).isEqualTo(1);
        assertThat(board.pieceCountOf(BLACK, PAWN)).isEqualTo(8);

        assertThat(board.pieceCountOf(WHITE, KNIGHT)).isEqualTo(2);
        assertThat(board.pieceCountOf(WHITE, KING)).isEqualTo(1);
        assertThat(board.pieceCountOf(WHITE, PAWN)).isEqualTo(8);
    }

    @Test
    @DisplayName("입력된 위치의 piece객체를 반환한다.")
    void find_piece() {
        board.initialize();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlack(ROOK, new Position("a8")));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlack(ROOK, new Position("h8")));

        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhite(ROOK, new Position("a1")));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhite(ROOK, new Position("h1")));

        assertThat(board.findPiece("a4")).isEqualTo(Piece.createBlank(new Position("a4")));
    }

    @Test
    @DisplayName("기물을 특정한 위치에 추가할 수 있다.")
    void put_piece_in_position() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlack(ROOK, new Position(position));
        board.move(piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("현재 남아 있는 기물에 따라 점수를 계산한다.")
    void calculate_score() {
        board.initializeEmpty();

        board.move(Piece.createBlack(PAWN, new Position("b6")));  // 1.0
        board.move(Piece.createBlack(QUEEN, new Position("e6"))); // 9.0
        board.move(Piece.createBlack(KING, new Position("b8")));
        board.move(Piece.createBlack(ROOK, new Position("c8")));  // 5.0

        board.move(Piece.createWhite(PAWN, new Position("f2")));  // 1.0
        board.move(Piece.createWhite(PAWN, new Position("g2")));  // 1.0
        board.move(Piece.createWhite(ROOK, new Position("e1")));  // 5.0
        board.move(Piece.createWhite(KING, new Position("f1")));

        System.out.println(board.showBoard());

        assertThat(board.calculateScoreOf(WHITE)).isEqualTo(7.0);
        assertThat(board.calculateScoreOf(BLACK)).isEqualTo(15.0);
    }

    @Test
    @DisplayName("두개의 pawn이 세로로 있는 경우 0.5이 된다.")
    void calculate_pawn_duplicate_score() {
        board.initializeEmpty();

        board.move(Piece.createBlack(PAWN, new Position("a8")));  // 0.5
        board.move(Piece.createBlack(PAWN, new Position("a7")));  // 0.5
        board.move(Piece.createBlack(PAWN, new Position("b8")));  // 0.5
        board.move(Piece.createBlack(PAWN, new Position("b7")));  // 0.5
        board.move(Piece.createBlack(KING, new Position("c8")));
        board.move(Piece.createBlack(QUEEN, new Position("a6"))); // 9.0
        board.move(Piece.createBlack(PAWN, new Position("a4")));  // 0.5
        board.move(Piece.createBlack(PAWN, new Position("a5")));  // 0.5

        board.move(Piece.createWhite(PAWN, new Position("b1")));  // 0.5
        board.move(Piece.createWhite(PAWN, new Position("b2")));  // 0.5
        board.move(Piece.createWhite(PAWN, new Position("b3")));  // 0.5
        board.move(Piece.createWhite(PAWN, new Position("d2")));  // 0.5
        board.move(Piece.createWhite(PAWN, new Position("d3")));  // 0.5
        board.move(Piece.createWhite(PAWN, new Position("d4")));  // 0.5

        System.out.println(board.showBoard());

        assertThat(board.calculateScoreOf(BLACK)).isEqualTo(12.0);
        assertThat(board.calculateScoreOf(WHITE)).isEqualTo(3.0);
    }

    @Test
    @DisplayName("각 색에 해당하는 기물들을 점수가 높은 순서에서 낮은 순으로 정렬한다.")
    void sort_remains_in_score_order() {
        board.initializeEmpty();

        board.move(Piece.createWhite(PAWN, new Position("a1")));
        board.move(Piece.createWhite(PAWN, new Position("a3")));
        board.move(Piece.createWhite(ROOK, new Position("b2")));
        board.move(Piece.createWhite(KNIGHT, new Position("c3")));
        board.move(Piece.createWhite(BISHOP, new Position("d4")));
        board.move(Piece.createWhite(QUEEN, new Position("e5")));
        board.move(Piece.createWhite(KING, new Position("f6")));

        board.move(Piece.createBlack(QUEEN, new Position("g7")));
        board.move(Piece.createBlack(ROOK, new Position("h8")));

        System.out.println(board.showBoard());

        System.out.println();
        System.out.println("BLACK : " + board.getRemainedPiecesInOrder(BLACK));
        System.out.println("WHITE : " + board.getRemainedPiecesInOrder(WHITE));

        assertThat(board.getRemainedPiecesInOrder(BLACK)).isEqualTo(
                Arrays.asList(QUEEN, ROOK));
        assertThat(board.getRemainedPiecesInOrder(WHITE)).isEqualTo(
                Arrays.asList(QUEEN, ROOK, BISHOP, KNIGHT, PAWN, PAWN, KING));
        // todo : 더 적절한 테스트 메서드를 찾아보자.
    }
}
