package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;
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
        Piece[] testPieces = {
                new Piece(Color.BLACK),
                new Piece(Color.WHITE)
        };

        for (int i = 0; i < testPieces.length; i++) {
            final int index = i;
            assertAll(
                    () -> verifyAddition(testPieces[index], index),
                    () -> verifySearchByIndex(testPieces[index], index)
            );
        }
    }

    private void verifyAddition(Piece piece, int index) {
        int size = index + 1;
        board.add(piece);
        assertThat(board.size()).isEqualTo(size);
    }

    private void verifySearchByIndex(Piece piece, int index) {
        assertThat(piece).isEqualTo(board.findPawn(index));
    }

    @Test
    @DisplayName("initialize 메소드 호출에 따라 각 폰의 표현문자 정상출력")
    void checkRepresentationOfInitialize() {
        board.initialize();
        assertAll(
                () -> verifyRepresentationOfPawns(Color.WHITE, "pppppppp"),
                () -> verifyRepresentationOfPawns(Color.BLACK, "PPPPPPPP")
        );
    }

    private void verifyRepresentationOfPawns(Color color, String representationOfExpected) {
        assertThat(board.getRowOfPawns(color)).isEqualTo(representationOfExpected);
    }
}
