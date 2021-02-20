package cooper.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {
    @Test
    @DisplayName("흰색 또는 검은색 기물이 각각 생성됨을 확인한다.")
    public void create() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, 'P'),
                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, 'p'),

                () -> verifyPiece(Piece.createWhiteKnight(), Color.WHITE, 'N'),
                () -> verifyPiece(Piece.createBlackKnight(), Color.BLACK, 'n'),

                () -> verifyPiece(Piece.createWhiteRook(), Color.WHITE, 'R'),
                () -> verifyPiece(Piece.createBlackRook(), Color.BLACK, 'r'),

                () -> verifyPiece(Piece.createWhiteBishop(), Color.WHITE, 'B'),
                () -> verifyPiece(Piece.createBlackBishop(), Color.BLACK, 'b'),

                () -> verifyPiece(Piece.createWhiteQueen(), Color.WHITE, 'Q'),
                () -> verifyPiece(Piece.createBlackQueen(), Color.BLACK, 'q'),

                () -> verifyPiece(Piece.createWhiteKing(), Color.WHITE, 'K'),
                () -> verifyPiece(Piece.createBlackKing(), Color.BLACK, 'k')
        );
    }

    void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertAll(
                () -> assertEquals(color, piece.getColor()),
                () -> assertEquals(representation, piece.getRepresentation())
        );
    }
}
