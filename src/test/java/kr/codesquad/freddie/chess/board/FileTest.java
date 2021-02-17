package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    @DisplayName("8개 초과하여 추가하는 경우")
    void add_moreThan_8() {
        for (int i = 0; i < File.SIZE; i++) {
            file.add(new Pawn());
        }

        assertThatThrownBy(() -> file.add(new Pawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 당 8개만 추가 가능합니다.");
    }

    @Test
    void get() {
        Pawn pawnA = new Pawn();
        Pawn pawnB = new Pawn(Color.BLACK);
        file.add(pawnA);
        file.add(pawnB);

        assertAll(
                () -> assertThat(file.get('a')).isEqualTo(pawnA).isEqualTo(file.get(0)),
                () -> assertThat(file.get('b')).isEqualTo(pawnB).isEqualTo(file.get(1))
        );
    }

    @Test
    @DisplayName("a~h를 벗어나도록 get을 하는 경우")
    void get_outOfRange() {
        for (int i = 0; i < File.SIZE; i++) {
            file.add(new Pawn());
        }

        assertAll(
                () -> assertThatThrownBy(() -> file.get('i'))
                        .isInstanceOf(IndexOutOfBoundsException.class),
                () -> assertThatThrownBy(() -> file.get((char) 96))
                        .isInstanceOf(ArrayIndexOutOfBoundsException.class),
                () -> assertThatThrownBy(() -> file.get('0'))
                        .isInstanceOf(ArrayIndexOutOfBoundsException.class),
                () -> assertThatThrownBy(() -> file.get((char) 0))
                        .isInstanceOf(ArrayIndexOutOfBoundsException.class)
        );
    }

    @Test
    void isAddable() {
        for (int i = 0; i < File.SIZE - 1; i++) {
            file.add(new Pawn());
            assertThat(file.isAddable()).isTrue();
        }

        file.add(new Pawn());
        assertThat(file.isAddable()).isFalse();
    }

    @Test
    void fillWith_black() {
        file.fillWith(Color.BLACK);
        checkFillWith(Color.BLACK);
    }

    @Test
    void fillWith_white() {
        file.fillWith(Color.WHITE);
        checkFillWith(Color.WHITE);
    }

    private void checkFillWith(Color expected) {
        for (int i = 0; i < File.SIZE; i++) {
            assertThat(file.get(i).getColor()).isEqualTo(expected);
        }
    }

    @Test
    void getRepresentation_fillWithBlack() {
        file.fillWith(Color.BLACK);
        assertThat(file.getRepresentation()).isEqualTo("PPPPPPPP");
    }

    @Test
    void getRepresentation_fillWithWhite() {
        file.fillWith(Color.WHITE);
        assertThat(file.getRepresentation()).isEqualTo("pppppppp");
    }
}
