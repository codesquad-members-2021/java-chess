package chess.domain.board;

import chess.domain.board.position.Position;
import chess.domain.pieces.Pawn;
import chess.domain.pieces.Queen;
import chess.domain.pieces.Rook;
import chess.view.BoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.utils.StringUtils.NEWLINE;
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

    @Test
    @DisplayName("기물을 체스판 위에 추가")
    void put() {
        board.put(Position.of("b5"), Rook.ofBlack());
        board.put(Position.of("f5"), Queen.ofWhite());

        StringBuilder sb = new StringBuilder();
        sb.append("  a b c d e f g h ").append(NEWLINE);
        sb.append("8 R N B Q K B N R ").append(NEWLINE);
        sb.append("7 P P P P P P P P ").append(NEWLINE);
        sb.append("6 . . . . . . . . ").append(NEWLINE);
        sb.append("5 . R . . . q . . ").append(NEWLINE);
        sb.append("4 . . . . . . . . ").append(NEWLINE);
        sb.append("3 . . . . . . . . ").append(NEWLINE);
        sb.append("2 p p p p p p p p ").append(NEWLINE);
        sb.append("1 r n b q k b n r ").append(NEWLINE);
        assertThat(boardView.getBoardRepresentation())
                .isEqualTo(sb.toString());
    }
}
