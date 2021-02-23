package net.nas.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChessCoordinateTest {
    @Test
    @DisplayName("문자열 좌표를 체스판배열에서의 좌표로 변환할 수 있어야 합니다.")
    void testParseStringCoordinate() {
        for (int i = 0; i < Board.LENGTH_OF_BOARD; i++) {
            for (int j = 0; j < Board.LENGTH_OF_BOARD; j++) {
                String stringCoordinate = String.format("%c%d", ('a' + j), (i + 1));
                ChessCoordinate coordinate = ChessCoordinate.parseStringCoordinate(stringCoordinate);
                assertThat(coordinate.rankIndex).isEqualTo(i);
                assertThat(coordinate.fileIndex).isEqualTo(j);
            }
        }
    }
}