package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;
import org.junit.jupiter.api.*;
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
    @DisplayName("초기화 된 보드의 기물의 개수가 32개여야 한다.")
    public void size() {
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("타입 별 기물의 개수가 일치해야 한다.")
    public void count() {
        assertThat(board.targetPieceCount(Color.WHITE, PieceType.PAWN)).isEqualTo(8);
        assertThat(board.targetPieceCount(Color.BLACK, PieceType.ROOK)).isEqualTo(2);
        assertThat(board.targetPieceCount(Color.WHITE, PieceType.KNIGHT)).isEqualTo(2);
        assertThat(board.targetPieceCount(Color.BLACK, PieceType.BISHOP)).isEqualTo(2);
        assertThat(board.targetPieceCount(Color.WHITE, PieceType.QUEEN)).isEqualTo(1);
        assertThat(board.targetPieceCount(Color.BLACK, PieceType.KING)).isEqualTo(1);
        assertThat(board.targetPieceCount(Color.NOCOLOR, PieceType.NO_PIECE)).isEqualTo(32);
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
    @DisplayName("체스판에 해당하는 좌표의 기물을 가져올 수 있어야 한다.")
    public void findPiece() {
        assertThat(board.findPiece("a8")).isEqualTo(Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position("a8")));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position("h8")));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createPiece(Color.WHITE, PieceType.ROOK, new Position("a1")));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createPiece(Color.WHITE, PieceType.ROOK, new Position("h1")));
    }

    @Test
    @DisplayName("체스판에 임의의 기물을 추가할 수 있어야 한다.")
    public void move() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position(position));
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard(Color.WHITE));
    }

    @Test
    @DisplayName("체스판 위에 흰색, 검은색 기물의 점수가 일치해야 한다.")
    public void calculatePoint()  {
        board.initializeEmpty();

        addPiece("b6", Piece.createPiece(Color.BLACK, PieceType.PAWN, new Position("b6")));
        addPiece("e6", Piece.createPiece(Color.BLACK, PieceType.QUEEN, new Position("e6")));
        addPiece("b8", Piece.createPiece(Color.BLACK, PieceType.KING, new Position("b8")));
        addPiece("c8", Piece.createPiece(Color.BLACK, PieceType.ROOK, new Position("c8")));

        addPiece("f2", Piece.createPiece(Color.WHITE, PieceType.PAWN, new Position("f2")));
        addPiece("f3", Piece.createPiece(Color.WHITE, PieceType.PAWN, new Position("f3")));
        addPiece("e1", Piece.createPiece(Color.WHITE, PieceType.ROOK, new Position("e1")));
        addPiece("f1", Piece.createPiece(Color.WHITE, PieceType.KING, new Position("f1")));

        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(6.0);

        System.out.println(board.showBoard(Color.WHITE));
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

}
