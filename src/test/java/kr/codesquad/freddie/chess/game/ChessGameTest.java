package kr.codesquad.freddie.chess.game;

import kr.codesquad.freddie.chess.board.Board;
import kr.codesquad.freddie.chess.ChessTestBase;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;
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
        Piece pawn = new Piece(color, Kind.PAWN);

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
    void movePawn() {
        initBoardWithBlank();
        checkMove("a2", "a3", whitePieceFactory.createPawn());
        checkMove("a2", "a4", whitePieceFactory.createPawn());
        checkMove("a7", "a6", blackPieceFactory.createPawn());
        checkMove("a7", "a5", blackPieceFactory.createPawn());
    }

    @Test
    void movePawnToOtherColor() {
        initBoardWithBlank();
        board.set("b3", blackPieceFactory.createPawn());
        board.set("c3", blackPieceFactory.createPawn());
        board.set("b6", whitePieceFactory.createPawn());
        board.set("c6", whitePieceFactory.createPawn());
        checkMove("a2", "b3", whitePieceFactory.createPawn());
        checkMove("d2", "c3", whitePieceFactory.createPawn());
        checkMove("a7", "b6", blackPieceFactory.createPawn());
        checkMove("d7", "c6", blackPieceFactory.createPawn());
    }

    @Test
    void movePawnToWrongTarget() {
        initBoardWithBlank();
        checkMoveToWrongTarget("a2", "a1", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("a7", "a8", blackPieceFactory.createPawn());
        checkMoveToWrongTarget("a2", "a5", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("a7", "a4", blackPieceFactory.createPawn());
        checkMoveToWrongTarget("a2", "b3", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("d2", "c3", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("a7", "b6", blackPieceFactory.createPawn());
        checkMoveToWrongTarget("a7", "c6", blackPieceFactory.createPawn());
        board.set("b4", blackPieceFactory.createPawn());
        board.set("c4", blackPieceFactory.createPawn());
        board.set("b5", whitePieceFactory.createPawn());
        board.set("c5", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("a2", "b4", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("d2", "c4", whitePieceFactory.createPawn());
        checkMoveToWrongTarget("a7", "b5", blackPieceFactory.createPawn());
        checkMoveToWrongTarget("a7", "c5", blackPieceFactory.createPawn());
    }

    @Test
    void moveKnight() {
        initBoardWithBlank();
        checkMove("d4", "c6", blackPieceFactory.createKnight());
        checkMove("d4", "b5", blackPieceFactory.createKnight());
        checkMove("d4", "b3", blackPieceFactory.createKnight());
        checkMove("d4", "c2", blackPieceFactory.createKnight());
        checkMove("d4", "e2", blackPieceFactory.createKnight());
        checkMove("d4", "f3", blackPieceFactory.createKnight());
        checkMove("d4", "f5", blackPieceFactory.createKnight());
        checkMove("d4", "e6", blackPieceFactory.createKnight());
    }

    @Test
    void moveKnightToWrongTarget() {
        initBoardWithBlank();
        checkMoveToWrongTarget("d4", "a4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "b4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "c4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "e4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "f4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "g4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "h4", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "d1", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "d2", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "d3", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "d5", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "d6", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "d7", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "c7", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "a5", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "a3", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "c1", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "e1", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "g3", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "g5", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "e7", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "b6", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "b2", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "f2", blackPieceFactory.createKnight());
        checkMoveToWrongTarget("d4", "f6", blackPieceFactory.createKnight());
    }

    @Test
    void moveRook() {
        initBoardWithBlank();
        checkMove("d4", "d5", blackPieceFactory.createRook());
        checkMove("d4", "d6", blackPieceFactory.createRook());
        checkMove("d4", "d3", blackPieceFactory.createRook());
        checkMove("d4", "d2", blackPieceFactory.createRook());
        checkMove("d4", "c4", blackPieceFactory.createRook());
        checkMove("d4", "b4", blackPieceFactory.createRook());
        checkMove("d4", "e4", blackPieceFactory.createRook());
        checkMove("d4", "f4", blackPieceFactory.createRook());
    }

    @Test
    void moveRookToWrongTarget() {
        initBoardWithBlank();
        checkMoveToWrongTarget("d4", "e5", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "f6", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "e3", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "f2", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "c5", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "b6", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "c3", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "b2", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "c6", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "b5", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "b3", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "c2", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "e2", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "f3", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "f5", blackPieceFactory.createRook());
        checkMoveToWrongTarget("d4", "e6", blackPieceFactory.createRook());
    }

    @Test
    void moveBishop() {
        initBoardWithBlank();
        checkMove("d4", "e5", blackPieceFactory.createBishop());
        checkMove("d4", "f6", blackPieceFactory.createBishop());
        checkMove("d4", "e3", blackPieceFactory.createBishop());
        checkMove("d4", "f2", blackPieceFactory.createBishop());
        checkMove("d4", "c5", blackPieceFactory.createBishop());
        checkMove("d4", "b6", blackPieceFactory.createBishop());
        checkMove("d4", "c3", blackPieceFactory.createBishop());
        checkMove("d4", "b2", blackPieceFactory.createBishop());
    }

    @Test
    void moveBishopToWrongTarget() {
        initBoardWithBlank();
        checkMoveToWrongTarget("d4", "d5", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "d6", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "d3", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "d2", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "c4", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "b4", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "e4", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "f4", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "c6", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "b5", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "b3", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "c2", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "e2", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "f3", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "f5", blackPieceFactory.createBishop());
        checkMoveToWrongTarget("d4", "e6", blackPieceFactory.createBishop());
    }

    @Test
    void moveQueen() {
        initBoardWithBlank();
        checkMove("d4", "d5", blackPieceFactory.createQueen());
        checkMove("d4", "d6", blackPieceFactory.createQueen());
        checkMove("d4", "d3", blackPieceFactory.createQueen());
        checkMove("d4", "d2", blackPieceFactory.createQueen());
        checkMove("d4", "c4", blackPieceFactory.createQueen());
        checkMove("d4", "b4", blackPieceFactory.createQueen());
        checkMove("d4", "e4", blackPieceFactory.createQueen());
        checkMove("d4", "f4", blackPieceFactory.createQueen());

        checkMove("d4", "e5", blackPieceFactory.createQueen());
        checkMove("d4", "f6", blackPieceFactory.createQueen());
        checkMove("d4", "e3", blackPieceFactory.createQueen());
        checkMove("d4", "f2", blackPieceFactory.createQueen());
        checkMove("d4", "c5", blackPieceFactory.createQueen());
        checkMove("d4", "b6", blackPieceFactory.createQueen());
        checkMove("d4", "c3", blackPieceFactory.createQueen());
        checkMove("d4", "b2", blackPieceFactory.createQueen());
    }

    @Test
    void moveQueenToWrongTarget() {
        initBoardWithBlank();
        checkMoveToWrongTarget("d4", "c6", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "b5", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "b3", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "c2", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "e2", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "f3", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "f5", blackPieceFactory.createQueen());
        checkMoveToWrongTarget("d4", "e6", blackPieceFactory.createQueen());
    }

    @Test
    void moveKing() {
        initBoardWithBlank();
        checkMove("b3", "b4", blackPieceFactory.createKing());
        checkMove("b3", "b2", blackPieceFactory.createKing());
        checkMove("b3", "c3", blackPieceFactory.createKing());
        checkMove("b3", "a3", blackPieceFactory.createKing());
        checkMove("b3", "c4", blackPieceFactory.createKing());
        checkMove("b3", "a4", blackPieceFactory.createKing());
        checkMove("b3", "c2", blackPieceFactory.createKing());
        checkMove("b3", "a2", blackPieceFactory.createKing());
    }

    @Test
    void moveKingToWrongTarget() {
        initBoardWithBlank();
        checkMoveToWrongTarget("b3", "b5", blackPieceFactory.createKing());
        checkMoveToWrongTarget("b3", "b1", blackPieceFactory.createKing());
        checkMoveToWrongTarget("b3", "d3", blackPieceFactory.createKing());
        checkMoveToWrongTarget("c3", "a3", blackPieceFactory.createKing());
    }

    @Test
    void moveEmptyPiece() {
        initBoardWithBlank();
        assertThatThrownBy(() -> chessGame.move("a1", "a2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치가 올바르지 않습니다. : source : a1, target : a2");
    }

    private void checkMove(String source, String target, Piece piece) {
        board.set(source, piece);
        chessGame.move(source, target);

        assertThat(board.findPiece(source)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(target)).isEqualTo(piece);
    }

    private void checkMoveToWrongTarget(String source, String target, Piece piece) {
        board.set(source, piece);
        assertThatThrownBy(() -> chessGame.move(source, target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveToDifferentColor() {
        initBoardWithBlank();
        board.set("b3", blackPieceFactory.createKing());
        board.set("b4", whitePieceFactory.createPawn());

        chessGame.move("b3", "b4");

        assertThat(board.findPiece("b3")).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece("b4")).isEqualTo(blackPieceFactory.createKing());
    }

    @Test
    void moveToSameColor() {
        initBoardWithBlank();
        board.set("b3", blackPieceFactory.createKing());
        board.set("b4", blackPieceFactory.createPawn());

        assertThatThrownBy(() -> chessGame.move("b3", "b4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치의 기물이 같은 색상입니다. source : Piece{color=BLACK, kind=KING}, target : Piece{color=BLACK, kind=PAWN}");
        assertThatThrownBy(() -> chessGame.move("b3", "b3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 위치의 기물이 같은 색상입니다. source : Piece{color=BLACK, kind=KING}, target : Piece{color=BLACK, kind=KING}");
    }

    private void initBoardWithBlank() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(Piece.createBlank());
        }
    }
}
