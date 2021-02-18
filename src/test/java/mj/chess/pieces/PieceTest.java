package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("기본 생성자로 흰색 폰 생성")
    void createPawn() {
        verifyColorOfPawn(new Piece(), Color.WHITE);
    }

    @Test
    @DisplayName("흰색과 검은색 폰 생성")
    void createPawns() {
        for (Color color : Color.values()) verifyColorOfPawn(new Piece(color), color);
    }

    @Test
    @DisplayName("흰색과 검은색 폰의 표현문자 정상출력 확인")
    void printRepresentationOfPawns() {
        verifyRepresentationOfPawn(new Piece(Color.WHITE, Piece.WHITE_REPRESENTATION), Piece.WHITE_REPRESENTATION);
        verifyRepresentationOfPawn(new Piece(Color.BLACK, Piece.BLACK_REPRESENTATION), Piece.BLACK_REPRESENTATION);
    }

    private void verifyColorOfPawn(Piece piece, Color color) {
        assertThat(piece.getColor()).isEqualTo(color);
    }

    private void verifyRepresentationOfPawn(Piece piece, final char representation) {
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}
