package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PieceTest {

    @Test
    @DisplayName("팩토리 메소드를 통해 각 기물은 알맞는 이름, 색상, 출력을 가져야한다.")
    void create_pieces() {
        verifyPiece(Piece.createWhitePawn()  , "pawn"  , Color.WHITE, "p");
        verifyPiece(Piece.createWhiteKnight(), "knight", Color.WHITE, "n");
        verifyPiece(Piece.createWhiteRook()  , "rook"  , Color.WHITE, "r");
        verifyPiece(Piece.createWhiteBishop(), "bishop", Color.WHITE, "b");
        verifyPiece(Piece.createWhiteQueen() , "queen" , Color.WHITE, "q");
        verifyPiece(Piece.createWhiteKing()  , "king"  , Color.WHITE, "k");
        verifyPiece(Piece.createBlackPawn()  , "pawn"  , Color.BLACK, "P");
        verifyPiece(Piece.createBlackKnight(), "knight", Color.BLACK, "N");
        verifyPiece(Piece.createBlackRook()  , "rook"  , Color.BLACK, "R");
        verifyPiece(Piece.createBlackBishop(), "bishop", Color.BLACK, "B");
        verifyPiece(Piece.createBlackQueen() , "queen" , Color.BLACK, "Q");
        verifyPiece(Piece.createBlackKing()  , "king"  , Color.BLACK, "K");
    }

    private void verifyPiece(final Piece piece
            , final String name, final Color color, final String representation) {
        assertThat(piece.getName()).isEqualTo(name);
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("piece 객체의 색상이 흰색인지 검은색인지 참 거짓으로 구분할 수 있다.")
    void check_color() {
        Piece whitePawn = Piece.createWhitePawn();

        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whitePawn.isBlack()).isFalse();

        Piece blackKing = Piece.createBlackKing();

        assertThat(blackKing.isBlack()).isTrue();
        assertThat(blackKing.isWhite()).isFalse();
    }
}
