package cooper.chess;

import cooper.chess.piece.Color;
import cooper.chess.piece.Piece;
import cooper.chess.piece.Position;
import cooper.chess.piece.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static cooper.chess.utils.StringUtils.NEW_LINE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("모든 기물이 생성됨을 확인한다.")
    public void create() {
        assertEquals(32, board.pieceCount());

        StringBuilder sb = new StringBuilder();
        String blankRank = "........";

        sb.append("RNBQKBNR").append(NEW_LINE);
        sb.append("PPPPPPPP").append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append("pppppppp").append(NEW_LINE);
        sb.append("rnbqkbnr").append(NEW_LINE);

        assertEquals(
                sb.toString(),
                board.showBoard()
        );
    }

    @Test
    @DisplayName("board의 상태를 확인한다.")
    public void getBoardStatusTest() {
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("원하는 색상과 기물의 수를 확인할 수 있다")
    public void getPieCountTest() {
        assertAll(
                () -> verifyPieceCount(Color.WHITE, Type.PAWN, 8),
                () -> verifyPieceCount(Color.WHITE, Type.KNIGHT, 2),
                () -> verifyPieceCount(Color.WHITE, Type.ROOK, 2),
                () -> verifyPieceCount(Color.WHITE, Type.BISHOP, 2),
                () -> verifyPieceCount(Color.WHITE, Type.QUEEN, 1),
                () -> verifyPieceCount(Color.WHITE, Type.KING, 1),

                () -> verifyPieceCount(Color.BLACK, Type.PAWN, 8),
                () -> verifyPieceCount(Color.BLACK, Type.KNIGHT, 2),
                () -> verifyPieceCount(Color.BLACK, Type.ROOK, 2),
                () -> verifyPieceCount(Color.BLACK, Type.BISHOP, 2),
                () -> verifyPieceCount(Color.BLACK, Type.QUEEN, 1),
                () -> verifyPieceCount(Color.BLACK, Type.KING, 1)
        );
    }

    void verifyPieceCount(final Color color, final Type type, final int count) {
        assertEquals(board.getPieceCount(color, type), count);
    }

    @Test
    @DisplayName("원하는 위치의 기물을 확인한다.")
    public void findPieceTest() {
        assertAll(
                () -> assertEquals(Piece.createWhiteRook(), board.findPiece(new Position("a8"))),
                () -> assertEquals(Piece.createWhiteRook(), board.findPiece(new Position("h8"))),
                () -> assertEquals(Piece.createBlackRook(), board.findPiece(new Position("a1"))),
                () -> assertEquals(Piece.createBlackRook(), board.findPiece(new Position("h1")))
        );
    }

    @Test
    @DisplayName("임의의 기물을 체스판 위에 추가")
    public void move() {
        board.initializeEmpty();

        Position prevPosition = new Position("b5");
        Position afterPosition = new Position("a1");

        Piece piece = Piece.createBlackRook();
        board.addPiece(prevPosition, piece);
        board.move(prevPosition, afterPosition);

        assertEquals(piece, board.findPiece(afterPosition));
    }

    @Test
    @DisplayName("색상의 체스판 점수 결과를 얻는다.")
    public void calculatePointTest() {
        board.initializeEmpty();

        assertAll(
                () -> board.addPiece(new Position("b6"), Piece.createBlackPawn()),
                () -> board.addPiece(new Position("e6"), Piece.createBlackQueen()),
                () -> board.addPiece(new Position("b8"), Piece.createBlackKing()),
                () -> board.addPiece(new Position("c8"), Piece.createBlackRook()),
                () -> board.addPiece(new Position("f2"), Piece.createWhitePawn()),
                () -> board.addPiece(new Position("g2"), Piece.createWhitePawn()),
                () -> board.addPiece(new Position("g6"), Piece.createWhitePawn()),
                () -> board.addPiece(new Position("e1"), Piece.createWhiteRook()),
                () -> board.addPiece(new Position("f1"), Piece.createWhiteKing())
        );

        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.5, board.calculatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }
}
