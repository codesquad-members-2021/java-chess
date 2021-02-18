package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("폰이 제대로 체스판 내에 추가 되었는지 확인한다.")
    void checkPawnInTheBoard() {
        board.addWhitePawn(new Piece(Color.WHITE));
        board.addBlackPawn(new Piece(Color.BLACK));

        assertAll(
                () -> assertThat(board.whitePawnSize()).isEqualTo(1),
                () -> assertThat(board.blackPawnSize()).isEqualTo(1),
                () -> assertThat(board.getWhitePawn(0).getColorName()).isEqualTo("white"),
                () -> assertThat(board.getBlackPawn(0).getColorName()).isEqualTo("black")

        );
    }

    @Test
    @DisplayName("폰의 색상에 맞게 초기화 되었는지 확인한다.")
    void initialize() {
        board.initialize();

        assertAll(
                () -> assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult()),
                () -> assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult())
        );
    }

    @Test
    @DisplayName("폰을 포함한 체스판의 출력이 정상적으로 이루어 지는지 확인한다.")
    void printBoard() {
        board.initialize();

        assertThat(board.showBoard()).isEqualTo(
                "........\n" +
                        "PPPPPPPP\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "........\n" +
                        "pppppppp\n" +
                        "........\n");
    }
}
