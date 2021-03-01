package piece;

import chess.Board;
import chess.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import piece.attribute.Color;
import piece.attribute.Type;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static piece.PieceFactory.createPiece;

class KnightTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initializeEmpty();
        board.addPiece(createPiece(Color.BLACK, Type.KNIGHT, "d4"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"b7", "c7", "f4", "g5", "d4", "h9"})
    @DisplayName("나이트가 이동범위를 벗어났을 때 에러 발생")
    void verifyMovePositionError(String position) {
        assertThatThrownBy(() -> board.findPiece(new Position("d4"))
                .isMovable(new Position(position)))
                .isInstanceOf(PositionNotMovableException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"c6", "e6", "b5", "f5", "f3", "b3", "c2", "e2"})
    @DisplayName("나이트가 모든 방향으로 정해진 칸만큼 이동할 수 있는지 확인")
    void verifyMovePosition(String position) {
        board.move(new Position("d4"), new Position(position));
    }
}

