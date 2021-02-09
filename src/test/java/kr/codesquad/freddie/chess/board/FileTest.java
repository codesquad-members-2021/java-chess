package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
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

    @Test
    void get() {
        File file = new File();
        Pawn pawn_a = new Pawn();
        Pawn pawn_b = new Pawn(Color.BLACK);
        file.add(pawn_a);
        file.add(pawn_b);

        assertThat(file.get('a')).isEqualTo(pawn_a);
        assertThat(file.get('b')).isEqualTo(pawn_b);
    }

    @Test
    void get_범위초과() {
        File file = new File();

        for (int i = 0; i < 8; i++) {
            file.add(new Pawn());
        }

        assertThatThrownBy(() -> file.get('i'))
                .isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> file.get((char) 96))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
        assertThatThrownBy(() -> file.get('0'))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
        assertThatThrownBy(() -> file.get((char) 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }
}
