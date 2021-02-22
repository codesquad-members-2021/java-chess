package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Kind;
import kr.codesquad.freddie.chess.piece.Piece;
import kr.codesquad.freddie.chess.piece.PieceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class FileTest extends TestBaseOfBoardPackage {
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
                file.add(new Piece(Color.WHITE, Kind.PAWN));
            }
            assertThat(file.size())
                    .isEqualTo(i);
        }
    }

    @Test
    @DisplayName("8개 초과하여 추가하는 경우")
    void add_moreThan_8() {
        for (int i = 0; i < File.SIZE; i++) {
            file.add(new Piece(Color.WHITE, Kind.PAWN));
        }

        assertThatThrownBy(() -> file.add(new Piece(Color.WHITE, Kind.PAWN)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 당 8개만 추가 가능합니다.");
    }

    @Test
    void get() {
        Piece pieceA = new Piece(Color.WHITE, Kind.PAWN);
        Piece pieceB = new Piece(Color.BLACK, Kind.PAWN);
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
        assertThat(file.getRepresentation()).isEqualTo("Q......q");
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

        assertAll(
                () -> assertThat(file.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(2),
                () -> assertThat(file.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(1),
                () -> assertThat(file.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(1),
                () -> assertThat(file.getNumberOf(Color.NOCOLOR, Kind.EMPTY)).isEqualTo(4)
        );
    }

    @Test
    void getPieceNumberBy_fillWithBlackPawn() {
        file.fillWithPawn(Color.BLACK);
        assertThat(file.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(8);
        assertThat(file.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KNIGHT)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.BISHOP)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.NOCOLOR, Kind.EMPTY)).isEqualTo(0);
    }

    @Test
    void getPieceNumberBy_fillWithBlackRoyal() {
        file.fillWithRoyal(Color.BLACK);
        assertThat(file.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(2);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KNIGHT)).isEqualTo(2);
        assertThat(file.getNumberOf(Color.BLACK, Kind.BISHOP)).isEqualTo(2);
        assertThat(file.getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(1);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(1);
        assertThat(file.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(0);

        assertThat(file.getNumberOf(Color.WHITE, Kind.ROOK)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KNIGHT)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.BISHOP)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KING)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(0);

        assertThat(file.getNumberOf(Color.NOCOLOR, Kind.EMPTY)).isEqualTo(0);
    }

    @Test
    void getPieceNumberBy_fillWithWhitePawn() {
        file.fillWithPawn(Color.WHITE);
        assertThat(file.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(8);
        assertThat(file.getNumberOf(Color.WHITE, Kind.ROOK)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KNIGHT)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.BISHOP)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KING)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.NOCOLOR, Kind.EMPTY)).isEqualTo(0);
    }

    @Test
    void getPieceNumberBy_fillWithWhiteRoyal() {
        file.fillWithRoyal(Color.WHITE);
        assertThat(file.getNumberOf(Color.WHITE, Kind.ROOK)).isEqualTo(2);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KNIGHT)).isEqualTo(2);
        assertThat(file.getNumberOf(Color.WHITE, Kind.BISHOP)).isEqualTo(2);
        assertThat(file.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(1);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KING)).isEqualTo(1);
        assertThat(file.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(0);

        assertThat(file.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KNIGHT)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.BISHOP)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(0);

        assertThat(file.getNumberOf(Color.NOCOLOR, Kind.EMPTY)).isEqualTo(0);
    }

    @Test
    void getPieceNumberBy_fillWithBlank() {
        file.fillWithBlank();

        assertThat(file.getNumberOf(Color.NOCOLOR, Kind.EMPTY)).isEqualTo(8);
        assertThat(file.getNumberOf(Color.BLACK, Kind.ROOK)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KNIGHT)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.BISHOP)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.QUEEN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.KING)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.BLACK, Kind.PAWN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.ROOK)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KNIGHT)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.BISHOP)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.QUEEN)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.KING)).isEqualTo(0);
        assertThat(file.getNumberOf(Color.WHITE, Kind.PAWN)).isEqualTo(0);
    }

    @Test
    void isAddable() {
        for (int i = 0; i < File.SIZE - 1; i++) {
            file.add(new Piece(Color.WHITE, Kind.PAWN));
            assertThat(file.isAddable()).isTrue();
        }

        file.add(new Piece(Color.WHITE, Kind.PAWN));
        assertThat(file.isAddable()).isFalse();
    }

    @Test
    void fillWith_black() {
        file.fillWithPawn(Color.BLACK);
        checkFillWith(Color.BLACK);
    }

    @Test
    void fillWith_white() {
        file.fillWithPawn(Color.WHITE);
        checkFillWith(Color.WHITE);
    }

    @Test
    void fillWith_blank() {
        file.fillWithBlank();
        checkFillWith(Color.NOCOLOR);
    }

    private void checkFillWith(Color expected) {
        for (int i = 0; i < File.SIZE; i++) {
            assertThat(file.get(i).getColor()).isEqualTo(expected);
        }
    }

    @Test
    void getRepresentation_fillWithBlackPawn() {
        file.fillWithPawn(Color.BLACK);
        assertThat(file.getRepresentation()).isEqualTo("PPPPPPPP");
    }

    @Test
    void getRepresentation_fillWithWhitePawn() {
        file.fillWithPawn(Color.WHITE);
        assertThat(file.getRepresentation()).isEqualTo("pppppppp");
    }

    @Test
    void getRepresentation_fillWithBlackRoyal() {
        file.fillWithRoyal(Color.BLACK);
        assertThat(file.getRepresentation()).isEqualTo("RNBQKBNR");
    }

    @Test
    void getRepresentation_fillWithWhiteRoyal() {
        file.fillWithRoyal(Color.WHITE);
        assertThat(file.getRepresentation()).isEqualTo("rnbqkbnr");
    }

    @Test
    void getRepresentation_fillWithBlank() {
        file.fillWithBlank();
        assertThat(file.getRepresentation()).isEqualTo("........");
    }
}
