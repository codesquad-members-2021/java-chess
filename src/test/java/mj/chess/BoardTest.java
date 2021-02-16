package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Board class에 Pawn class 추가 및 인덱스로 탐색")
    void createBoard() {
        Pawn[] testPawns = {
                new Pawn(Color.BLACK),
                new Pawn(Color.WHITE)
        };

        for (int i = 0; i < testPawns.length; i++) {
            final int index = i;
            assertAll(
                    () -> verifyAddition(testPawns[index], index),
                    () -> verifySearchByIndex(testPawns[index], index)
            );
        }
    }

    private void verifyAddition(Pawn pawn, int index) {
        int size = index + 1;
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
    }

    private void verifySearchByIndex(Pawn pawn, int index) {
        assertThat(pawn).isEqualTo(board.findPawn(index));
    }
}
