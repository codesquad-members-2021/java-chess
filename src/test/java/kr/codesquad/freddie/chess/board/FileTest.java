package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FileTest {
    private File file;

    @BeforeEach
    void setFile() {
        file = new File();
    }

    @Test
    void add() {
        for (int i = 0; i < File.SIZE; i++) {
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
        for (int i = 0; i < File.SIZE; i++) {
            file.add(new Pawn());
        }

        assertThatThrownBy(() -> file.add(new Pawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 당 8개만 추가 가능합니다.");
    }

    @Test
    void get() {
        Pawn pawn_a = new Pawn();
        Pawn pawn_b = new Pawn(Color.BLACK);
        file.add(pawn_a);
        file.add(pawn_b);

        assertThat(file.get('a')).isEqualTo(pawn_a);
        assertThat(file.get('b')).isEqualTo(pawn_b);
    }

    @Test
    void get_범위초과() {
        for (int i = 0; i < File.SIZE; i++) {
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
