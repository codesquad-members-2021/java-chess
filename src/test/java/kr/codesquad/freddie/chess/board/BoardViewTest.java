package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.ChessTestBase;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardViewTest extends ChessTestBase {
    private BoardView boardView;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("set으로 넣은 뒤 getRepresentation과 getNumberOf로 확인")
    void getRepresentation() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(PieceFactory.createBlank());
        }

        board.set("b8", blackPieceFactory.createKing());
        board.set("c8", blackPieceFactory.createRook());
        board.set("a7", blackPieceFactory.createPawn());
        board.set("c7", blackPieceFactory.createPawn());
        board.set("d7", blackPieceFactory.createBishop());
        board.set("b6", blackPieceFactory.createPawn());
        board.set("e6", blackPieceFactory.createQueen());
        board.set("f4", whitePieceFactory.createKnight());
        board.set("g4", whitePieceFactory.createQueen());
        board.set("f3", whitePieceFactory.createPawn());
        board.set("g2", whitePieceFactory.createPawn());
        board.set("e1", whitePieceFactory.createRook());
        board.set("f1", whitePieceFactory.createKing());

        String expected = new StringBuilder()
                .append(".KR.....").append(System.lineSeparator())
                .append("P.PB....").append(System.lineSeparator())
                .append(".P..Q...").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append(".....nq.").append(System.lineSeparator())
                .append(".....p..").append(System.lineSeparator())
                .append("......p.").append(System.lineSeparator())
                .append("....rk..")
                .toString();

        assertThat(boardView.getRepresentation()).isEqualTo(expected);
    }

    @Test
    void getRepresentationWithInitBoard() {
        initBoard();
        String representation = boardView.getRepresentation();

        String expected = new StringBuilder()
                .append("RNBQKBNR").append(System.lineSeparator())
                .append("PPPPPPPP").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("pppppppp").append(System.lineSeparator())
                .append("rnbqkbnr")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    @Test
    void getRepresentationNotInitBoard() {
        initBoardWithBlank();
        String representation = boardView.getRepresentation();

        String expected = new StringBuilder()
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........").append(System.lineSeparator())
                .append("........")
                .toString();
        assertThat(representation)
                .isEqualTo(expected);
    }

    private void initBoard() {
        board.initializePieceBy(Color.BLACK);
        board.initializeEmptyPiece();
        board.initializePieceBy(Color.WHITE);
    }

    private void initBoardWithBlank() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(PieceFactory.createBlank());
        }
    }
}
