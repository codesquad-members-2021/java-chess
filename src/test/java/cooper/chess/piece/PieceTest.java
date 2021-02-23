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

    @Test
    @DisplayName("타입에 따라 알맞는 representation을 반환한다.")
    public void getRepresentationPerPiece() {
        assertAll(
                () -> assertEquals('P', Type.PAWN.getRepresentaion(Color.WHITE)),
                () -> assertEquals('p', Type.PAWN.getRepresentaion(Color.BLACK)),

                () -> assertEquals('N', Type.KNIGHT.getRepresentaion(Color.WHITE)),
                () -> assertEquals('n', Type.KNIGHT.getRepresentaion(Color.BLACK)),

                () -> assertEquals('R', Type.ROOK.getRepresentaion(Color.WHITE)),
                () -> assertEquals('r', Type.ROOK.getRepresentaion(Color.BLACK)),

                () -> assertEquals('B', Type.BISHOP.getRepresentaion(Color.WHITE)),
                () -> assertEquals('b', Type.BISHOP.getRepresentaion(Color.BLACK)),

                () -> assertEquals('Q', Type.QUEEN.getRepresentaion(Color.WHITE)),
                () -> assertEquals('q', Type.QUEEN.getRepresentaion(Color.BLACK)),

                () -> assertEquals('K', Type.KING.getRepresentaion(Color.WHITE)),
                () -> assertEquals('k', Type.KING.getRepresentaion(Color.BLACK)),

                () -> assertEquals('.', Type.NO_PIECE.getRepresentaion(Color.NO_COLOR))
        );
    }
}
