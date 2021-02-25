package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Rook;
import chess.view.BoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;
    private BoardView boardView;

    @BeforeEach
    void setup() {
        board = BoardFactory.create();
        boardView = new BoardView(board);
    }

    @Test
    @DisplayName("까만 폰의 갯수를 센다.")
    void count_blackPawn() {
        assertThat(board.count(Pawn.ofBlack()))
                .isEqualTo(8);
    }

    @Test
    @DisplayName("하얀 룩의 갯수를 센다.")
    void count_whiteRook() {
        assertThat(board.count(Rook.ofWhite()))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 기물의 위치를 조회")
    void getPiece() {
        assertAll(
                () -> assertThat(board.getPiece(Position.of("a8")))
                        .isEqualTo(Rook.ofBlack()),
                () -> assertThat(board.getPiece(Position.of("h8")))
                        .isEqualTo(Rook.ofBlack()),
                () -> assertThat(board.getPiece(Position.of("a1")))
                        .isEqualTo(Rook.ofWhite()),
                () -> assertThat(board.getPiece(Position.of("h1")))
                        .isEqualTo(Rook.ofWhite())
        );
    }
}
