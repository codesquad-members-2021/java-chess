package kr.codesquad.freddie.chess.game;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.ChessTestBase;
import kr.codesquad.freddie.chess.piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ChessGameTest extends ChessTestBase {
    private ChessGame chessGame;
    private Board board;

    @BeforeEach
    void setUp() {
        chessGame = ChessGame.create();
        board = chessGame.getBoard();
    }

    @Test
    void initialize() {
        chessGame.initialize();
        Board board = chessGame.getBoard();
        checkInitializeRoyal(Color.BLACK, board);
        checkInitializeRoyal(Color.WHITE, board);
        checkInitializePawn(Color.BLACK, board);
        checkInitializePawn(Color.WHITE, board);
    }

    private void checkInitializeRoyal(Color color, Board board) {
        int rank = color == Color.BLACK ? 8 : 1;
        PieceFactory pieceFactory = new PieceFactory(color);

        assertThat(board.findPiece("a" + rank)).isEqualTo(pieceFactory.createRook());
        assertThat(board.findPiece("b" + rank)).isEqualTo(pieceFactory.createKnight());
        assertThat(board.findPiece("c" + rank)).isEqualTo(pieceFactory.createBishop());
        assertThat(board.findPiece("d" + rank)).isEqualTo(pieceFactory.createQueen());
        assertThat(board.findPiece("e" + rank)).isEqualTo(pieceFactory.createKing());
        assertThat(board.findPiece("f" + rank)).isEqualTo(pieceFactory.createBishop());
        assertThat(board.findPiece("g" + rank)).isEqualTo(pieceFactory.createKnight());
        assertThat(board.findPiece("h" + rank)).isEqualTo(pieceFactory.createRook());
    }

    private void checkInitializePawn(Color color, Board board) {
        int rank = color == Color.BLACK ? 7 : 2;
        Piece pawn = Pawn.create(color);

        assertThat(board.findPiece("a" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("b" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("c" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("d" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("e" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("f" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("g" + rank)).isEqualTo(pawn);
        assertThat(board.findPiece("h" + rank)).isEqualTo(pawn);
    }

    @Test
    void moveToDifferentColor() {
        chessGame.initialize();
        board.set("b3", blackPieceFactory.createKing());
        board.set("b4", whitePieceFactory.createPawn());

        chessGame.move("b3", "b4");

        assertThat(board.findPiece("b3")).isEqualTo(PieceFactory.createBlank());
        assertThat(board.findPiece("b4")).isEqualTo(blackPieceFactory.createKing());
    }

    @Test
    void moveToSameColor() {
        chessGame.initialize();
        board.set("b3", blackPieceFactory.createKing());
        board.set("b4", blackPieceFactory.createPawn());

        assertThatThrownBy(() -> chessGame.move("b3", "b4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치의 기물이 같은 색상입니다. source : Piece{color=BLACK, kind=KING}, target : Piece{color=BLACK, kind=PAWN}");
        assertThatThrownBy(() -> chessGame.move("b3", "b3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치의 기물이 같은 색상입니다. source : Piece{color=BLACK, kind=KING}, target : Piece{color=BLACK, kind=KING}");
    }
}
