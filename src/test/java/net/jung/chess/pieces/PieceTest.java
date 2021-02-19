package net.jung.chess.pieces;

import net.jung.chess.Color;
import net.jung.chess.Name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceTest {

    @Test
    @DisplayName("팩토리메서드로 생성되는 말의 색, 이름이 정확한지 검증한다.")
    void checkCreateFactoryMethod(){
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Name.PAWN, 'p');
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Name.PAWN, 'P');

        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Name.KNIGHT, 'n');
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Name.KNIGHT, 'N');

        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Name.ROOK, 'r');
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Name.ROOK, 'R');

        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Name.BISHOP, 'b');
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Name.BISHOP, 'B');

        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Name.QUEEN, 'q');
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Name.QUEEN, 'Q');

        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Name.KING, 'k');
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Name.KING, 'K');

    }

    private void verifyPiece(final Piece piece, final Color color, final Name name, final char representation){
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getName()).isEqualTo(name);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("isBlack isWhite는 색깔이 일치하면 true 아니면 false 리턴한다.")
    void isColorCheck(){
        assertAll(
                () -> assertThat(Piece.createWhiteKing().isBlack()).isFalse(),
                () -> assertThat(Piece.createBlackBishop().isBlack()).isTrue(),

                () -> assertThat(Piece.createBlackPawn().isWhite()).isFalse(),
                () -> assertThat(Piece.createWhiteKnight().isWhite()).isTrue()
        );
    }
}
