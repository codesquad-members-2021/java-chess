package chess.domain.board.position;

import chess.exception.BadPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class PositionTest {

    @Test
    @DisplayName("columnId 와 rowId 가 같다면, 같은 Position 이어야 한다.")
    void testEquals() {
        assertThat(Position.of('c', 4))
                .isEqualTo(Position.of("C4"));
    }

    @Test
    @DisplayName("columnId 와 rowId 가 같다면, hashCode 값도 같아야 한다.")
    void testHashCode() {
        assertThat(Position.of('f', 2).hashCode())
                .isEqualTo(Position.of("F2").hashCode());
    }

    @Test
    @DisplayName("체스판에 존재하지 않는 positionId 를 입력하면, BadPositionException 이 발생한다..")
    void badPositionException() {
        assertThatExceptionOfType(BadPositionException.class)
                .isThrownBy(() -> Position.of("Z9"));
    }
}
