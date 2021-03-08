package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.ChessTestBase;
import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class FileTest extends ChessTestBase {
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
                file.add(whitePieceFactory.createPawn());
            }
            assertThat(file.size())
                    .isEqualTo(i);
        }
    }

    @Test
    @DisplayName("8개 초과하여 추가하는 경우")
    void addMoreThan8() {
        for (int i = 0; i < File.SIZE; i++) {
            file.add(whitePieceFactory.createPawn());
        }

        assertThatThrownBy(() -> file.add(whitePieceFactory.createPawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 당 8개만 추가 가능합니다.");
    }

    @Test
    void get() {
        Piece pieceA = whitePieceFactory.createPawn();
        Piece pieceB = blackPieceFactory.createPawn();
        file.add(pieceA);
        file.add(pieceB);

        assertAll(
                () -> assertThat(file.get(0)).isEqualTo(pieceA).isEqualTo(file.get(0)),
                () -> assertThat(file.get(1)).isEqualTo(pieceB).isEqualTo(file.get(1))
        );
    }

    @Test
    void set() {
        file.fillWithBlank();

        assertThat(file.set(0, blackPieceFactory.createQueen())).isEqualTo(PieceFactory.createBlank());
        assertThat(file.set(7, whitePieceFactory.createQueen())).isEqualTo(PieceFactory.createBlank());
        assertThat(file.get(0)).isEqualTo(blackPieceFactory.createQueen());
        assertThat(file.get(7)).isEqualTo(whitePieceFactory.createQueen());
    }

    @Test
    void getPieceNumberBy() {

        file.add(blackPieceFactory.createRook());
        file.add(PieceFactory.createBlank());
        file.add(PieceFactory.createBlank());
        file.add(PieceFactory.createBlank());
        file.add(blackPieceFactory.createKing());
        file.add(whitePieceFactory.createQueen());
        file.add(PieceFactory.createBlank());
        file.add(blackPieceFactory.createRook());
    }

    @Test
    void isAddable() {
        for (int i = 0; i < File.SIZE - 1; i++) {
            file.add(whitePieceFactory.createPawn());
            assertThat(file.isAddable()).isTrue();
        }

        file.add(whitePieceFactory.createPawn());
        assertThat(file.isAddable()).isFalse();
    }

    @Test
    void fillWithBlack() {
        file.fillWithPawn(Color.BLACK);
        checkFillWith(Color.BLACK);
    }

    @Test
    void fillWithWhite() {
        file.fillWithPawn(Color.WHITE);
        checkFillWith(Color.WHITE);
    }

    @Test
    void fillWithBlank() {
        file.fillWithBlank();
        checkFillWith(Color.NOCOLOR);
    }

    private void checkFillWith(Color expected) {
        for (int i = 0; i < File.SIZE; i++) {
            assertThat(file.get(i).getColor()).isEqualTo(expected);
        }
    }
}
