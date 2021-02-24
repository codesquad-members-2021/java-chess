package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static net.eno.utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("초기화 된 보드의 기물의 배치가 일치해야 한다.")
    public void initialize() {
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard(Color.WHITE)).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        );
        assertThat(board.showBoard(Color.BLACK)).isEqualTo(
                appendNewLine("rnbkqbnr") +
                appendNewLine("pppppppp") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("PPPPPPPP") +
                appendNewLine("RNBKQBNR")
        );
    }

    @Test
    @DisplayName("초기화 된 보드가 출력되어야 한다.")
    public void print() {
        System.out.println("> 초기화 된 보드가 출력되어야 한다.");
        System.out.println(board.showBoard(Color.WHITE));
        System.out.println(board.showBoard(Color.BLACK));
    }

    @Test
    @DisplayName("타입 별 기물의 개수가 일치해야 한다.")
    public void count() {
        assertThat(board.countTargetPiece(Color.WHITE, PieceType.PAWN)).isEqualTo(8);
        assertThat(board.countTargetPiece(Color.BLACK, PieceType.ROOK)).isEqualTo(2);
        assertThat(board.countTargetPiece(Color.WHITE, PieceType.KNIGHT)).isEqualTo(2);
        assertThat(board.countTargetPiece(Color.BLACK, PieceType.BISHOP)).isEqualTo(2);
        assertThat(board.countTargetPiece(Color.WHITE, PieceType.QUEEN)).isEqualTo(1);
        assertThat(board.countTargetPiece(Color.BLACK, PieceType.KING)).isEqualTo(1);
        assertThat(board.countTargetPiece(Color.NOCOLOR, PieceType.NO_PIECE)).isEqualTo(32);
    }

    @Test
    @DisplayName("체스판에 해당하는 좌표의 기물을 가져올 수 있어야 한다.")
    public void findPiece() {
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createPiece(Color.BLACK, PieceType.ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createPiece(Color.BLACK, PieceType.ROOK));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createPiece(Color.WHITE, PieceType.ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createPiece(Color.WHITE, PieceType.ROOK));
    }

    @Test
    @DisplayName("체스판에 임의의 기물을 추가할 수 있어야 한다.")
    public void move() {
        System.out.println("> 체스판에 임의의 기물을 추가할 수 있어야 한다.");
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createPiece(Color.BLACK, PieceType.ROOK);
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard(Color.WHITE));
    }

    @Test
    @DisplayName("체스판 위에 흰색, 검은색 기물의 점수가 일치해야 한다.")
    public void calculatePoint()  {
        System.out.println("> 체스판 위에 흰색, 검은색 기물의 점수가 일치해야 한다.");
        board.initializeEmpty();

        addPiece("b6", Piece.createPiece(Color.BLACK, PieceType.PAWN));
        addPiece("e6", Piece.createPiece(Color.BLACK, PieceType.QUEEN));
        addPiece("b8", Piece.createPiece(Color.BLACK, PieceType.KING));
        addPiece("c8", Piece.createPiece(Color.BLACK, PieceType.ROOK));

        addPiece("f2", Piece.createPiece(Color.WHITE, PieceType.PAWN));
        addPiece("f3", Piece.createPiece(Color.WHITE, PieceType.PAWN));
        addPiece("e1", Piece.createPiece(Color.WHITE, PieceType.ROOK));
        addPiece("f1", Piece.createPiece(Color.WHITE, PieceType.KING));

        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(6.0);

        System.out.println(board.showBoard(Color.WHITE));
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    @DisplayName("체스판 위에 기물들이 점수별로 정렬되어야 한다.")
    public void sortByPoint() {
        System.out.println("> 체스판 위에 기물들이 점수별로 정렬되어야 한다.");
        List<Piece> pieceList;

        pieceList = board.sortByPiecePoint(Color.WHITE, true);
        showPieceList(pieceList);

        System.out.println();

        pieceList = board.sortByPiecePoint(Color.WHITE, false);
        showPieceList(pieceList);
    }

    private void showPieceList(List<Piece> pieceList) {
        for (Piece piece : pieceList) {
            System.out.println(piece.getColor() + " " + piece.getPieceType() + " " + piece.getPoint());
        }
    }

}
