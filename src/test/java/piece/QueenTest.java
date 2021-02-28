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

class QueenTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initializeEmpty();
        board.addPiece(createPiece(Color.WHITE, Type.QUEEN, "d4"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"b7", "c6", "f5", "g5", "d4", "h9"})
    @DisplayName("퀸이 이동범위를 벗어났을 때 에러 발생")
    void verifyMovePositionError(String position) {
        assertThatThrownBy(() -> board.findPiece(new Position("d4"))
                .isMovable(new Position(position)))
                .isInstanceOf(PositionNotMovableException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a7", "g7", "c5", "d5", "e5", "c4", "e4", "c3", "d5", "e5"})
    @DisplayName("퀸이 모든 방향으로 여러칸 이동할 수 있는지 확인")
    void verifyMovePosition(String position) {
        board.move(new Position("d4"), new Position(position));
    }
}

