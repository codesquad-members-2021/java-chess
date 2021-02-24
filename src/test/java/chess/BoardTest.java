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

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlack(ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlack(ROOK));

        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhite(ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhite(ROOK));

        assertThat(board.findPiece("a4")).isEqualTo(Piece.createBlank());
    }

    @Test
    @DisplayName("기물을 특정한 위치에 추가할 수 있다.")
    void put_piece_in_position() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlack(ROOK);
        board.putPieceIn(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("현재 남아 있는 기물에 따라 점수를 계산한다.")
    void calculate_score() {
        board.initializeEmpty();

        board.putPieceIn("b6", Piece.createBlack(PAWN));  // 1.0
        board.putPieceIn("e6", Piece.createBlack(QUEEN)); // 9.0
        board.putPieceIn("b8", Piece.createBlack(KING));
        board.putPieceIn("c8", Piece.createBlack(ROOK));  // 5.0

        board.putPieceIn("f2", Piece.createWhite(PAWN));  // 1.0
        board.putPieceIn("g2", Piece.createWhite(PAWN));  // 1.0
        board.putPieceIn("e1", Piece.createWhite(ROOK));  // 5.0
        board.putPieceIn("f1", Piece.createWhite(KING));

        System.out.println(board.showBoard());

        assertThat(board.calculatePoint(BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(WHITE)).isEqualTo(7.0);
    }

    @Test
    @DisplayName("두개의 pawn이 세로로 있는 경우 0.5이 된다.")
    void calculate_pawn_duplicate_score() {
        board.initializeEmpty();

        board.putPieceIn("a7", Piece.createBlack(PAWN));  // 0.5
        board.putPieceIn("a8", Piece.createBlack(PAWN));  // 0.5

        board.putPieceIn("b1", Piece.createWhite(PAWN));  // 0.5
        board.putPieceIn("b2", Piece.createWhite(PAWN));  // 0.5
        board.putPieceIn("d2", Piece.createWhite(PAWN));  // 0.5
        board.putPieceIn("d3", Piece.createWhite(PAWN));  // 0.5
        board.putPieceIn("d4", Piece.createWhite(PAWN));  // 0.5

        System.out.println(board.showBoard());

        assertThat(board.calculatePoint(WHITE)).isEqualTo(2.5);
        assertThat(board.calculatePoint(BLACK)).isEqualTo(1.0);
    }

    @Test
    @DisplayName("각 색에 해당하는 기물들을 점수가 높은 순서에서 낮은 순으로 정렬한다.")
    void sort_remains_in_score_order() {
        board.initializeEmpty();

        board.putPieceIn("a1", Piece.createWhite(PAWN));
        board.putPieceIn("a3", Piece.createWhite(PAWN));
        board.putPieceIn("b2", Piece.createWhite(ROOK));
        board.putPieceIn("c3", Piece.createWhite(KNIGHT));
        board.putPieceIn("d4", Piece.createWhite(BISHOP));
        board.putPieceIn("e5", Piece.createWhite(QUEEN));
        board.putPieceIn("f6", Piece.createWhite(KING));

        board.putPieceIn("g7", Piece.createBlack(QUEEN));
        board.putPieceIn("h8", Piece.createBlack(ROOK));

        System.out.println(board.showBoard());

        System.out.println();
        System.out.println("BLACK : " + board.getRemainedPiecesInOrder(BLACK));
        System.out.println("WHITE : " + board.getRemainedPiecesInOrder(WHITE));

        assertThat(board.getRemainedPiecesInOrder(BLACK)).isEqualTo(
                Arrays.asList(QUEEN, ROOK));
        assertThat(board.getRemainedPiecesInOrder(WHITE)).isEqualTo(
                Arrays.asList(QUEEN, ROOK, BISHOP, KNIGHT, PAWN, PAWN, KING));
        // todo : 적절한 테스트 메서드를 찾아보자.
    }
}
