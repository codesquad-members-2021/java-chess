package net.jung.chess.pieces;

import net.jung.chess.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("팩토리메서드로 생성되는 말의 색, 이름이 정확한지 검증한다.")
    void checkCreateFactoryMethod(){
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN, 'p');
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN, 'P');

        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT, 'n');
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT, 'N');

        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK, 'r');
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK, 'R');

        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP, 'b');
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP, 'B');

        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN, 'q');
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN, 'Q');

        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING, 'k');
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING, 'K');

    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type type, final char representation){
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getType()).isEqualTo(type),
                () ->  assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }

    @Test
    @DisplayName("isWhite isBlack은 색깔이 일치하면 true 아니면 false 리턴한다.")
    void checkIsColor(){
        assertAll(
                () -> assertThat(Piece.createWhiteKing().isBlack()).isFalse(),
                () -> assertThat(Piece.createBlackBishop().isBlack()).isTrue(),

                () -> assertThat(Piece.createBlackPawn().isWhite()).isFalse(),
                () -> assertThat(Piece.createWhiteKnight().isWhite()).isTrue()
        );
    }

    @Test
    @DisplayName("getWhiteRepresentation()은 Type representation의 소문자를 반환, getBlackRepresentation()은 대문자를 반환한다.")
    void checkGetColorRepresentation() {
        assertAll(
                () -> assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p'),
                () -> assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P'),
                () -> assertThat(Piece.Type.KNIGHT.getWhiteRepresentation()).isEqualTo('n'),
                () -> assertThat(Piece.Type.KNIGHT.getBlackRepresentation()).isEqualTo('N')
        );
    }
}
