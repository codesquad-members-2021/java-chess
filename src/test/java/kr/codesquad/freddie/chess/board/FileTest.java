package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Pawn;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FileTest {
    @Test
    void add() {
        int size = 8;

        for (int i = 0; i < size; i++) {
            File file = new File();

            for (int j = 0; j < i; j++) {
                file.add(new Pawn());
            }
            assertThat(file.size())
                    .isEqualTo(i);
        }
    }

    @Test
    void add_8개초과() {
        File file = new File();

        for (int i = 0; i < 8; i++) {
            file.add(new Pawn());
        }

        assertThatThrownBy(() -> file.add(new Pawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 당 8개만 추가 가능합니다.");
    }
}
