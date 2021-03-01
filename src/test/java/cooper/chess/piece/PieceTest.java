package cooper.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    @Test
    @DisplayName("알맞은 색상과 타입의 기물이 생성됨을 확인한다.")
    public void create_piece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN),
                () -> verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT),
                () -> verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK),
                () -> verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP),
                () -> verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN),
                () -> verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING)
        );
    }

    void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertAll(
                () -> assertTrue(whitePiece.isWhite()),
                () -> assertEquals(type, whitePiece.getType()),

                () -> assertTrue(blackPiece.isBlack()),
                () -> assertEquals(type, blackPiece.getType())
        );
    }

    @Test
    @DisplayName("blank가 제대로 생성되는지 확인한다.")
    public void create_blank() {
        assertEquals(Color.NO_COLOR,Piece.createBlank().getColor());
        assertEquals(Type.NO_PIECE,Piece.createBlank().getType());
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
