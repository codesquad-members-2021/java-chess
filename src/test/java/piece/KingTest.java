package piece;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import piece.attribute.*;
import org.junit.jupiter.params.ParameterizedTest;

import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;

class KingTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initializeEmpty();
        board.addPiece(createPiece(Color.BLACK, Type.KING, "d4"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"b6", "c6", "f5", "g5", "d4", "h9"})
    @DisplayName("킹이 이동범위를 벗어났을 때 에러 발생")
    void verifyMovePositionError(String position) {
        assertThatThrownBy(() -> board.findPiece(new Position("d4"))
                .isMovable(new Position(position)))
                .isInstanceOf(PositionNotMovableException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"c5", "d5", "e5", "c4", "e4", "c3", "d5", "e5"})
    @DisplayName("킹이 모든 방향으로 1칸씩 이동할 수 있는지 확인")
    void verifyMovePosition(String position) {
        board.move(new Position("d4"), new Position(position));
    }
}

