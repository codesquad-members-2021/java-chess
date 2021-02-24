package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("흑폰 백폰이 제대로 생성되는지 확인")
    void createPawnPiece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, 'p');
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, 'P');
    }

    @Test
    @DisplayName("흑나이트 백나이트가 제대로 생성되는지 확인")
    void createKnightPiece() {
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, 'n');
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, 'N');
    }

    @Test
    @DisplayName("흑룩 백룩이 제대로 생성되는지 확인")
    void createRookPiece() {
        verifyPiece(Piece.createWhiteRook(), Color.WHITE, 'r');
        verifyPiece(Piece.createBlackRook(), Color.BLACK, 'R');
    }

    @Test
    @DisplayName("흑비숍 백비숏이 제대로 생성되는지 확인")
    void createBishopPiece() {
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, 'b');
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, 'B');
    }

    @Test
    @DisplayName("흑퀸 백퀸이 제대로 생성되는지 확인")
    void createQueenPiece() {
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, 'q');
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, 'Q');
    }

    @Test
    @DisplayName("흑킹 백킹이 제대로 생성되는지 확인")
    void createKingPiece() {
        verifyPiece(Piece.createWhiteKing(), Color.WHITE, 'k');
        verifyPiece(Piece.createBlackKing(), Color.BLACK, 'K');
    }

    void verifyPiece(Piece piece, Color color, char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }

    @Test
    @DisplayName("생성된 기물이 폰이 맞는지 확인")
    void checkPawn() {
        assertAll(
                () -> assertThat(Piece.createBlackPawn().isPawn()).isTrue(),
                () -> assertThat(Piece.createWhiteBishop().isPawn()).isFalse()
        );
    }

    @Test
    @DisplayName("생성된 기물의 색이 올바른지 확인")
    void checkColor() {
        assertAll(
                () -> assertThat(Piece.createWhiteBishop().isWhite()).isTrue(),
                () -> assertThat(Piece.createBlackBishop().isBlack()).isTrue(),
                () -> assertThat(Piece.createWhiteKing().isBlack()).isFalse(),
                () -> assertThat(Piece.createBlackKing().isWhite()).isFalse()
        );
    }
}
