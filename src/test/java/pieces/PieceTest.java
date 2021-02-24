package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("흰색, 검은색 폰 생성")
    void createPawn() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_PAWN_SYMBOL);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_PAWN_SYMBOL);
    }

    @Test
    @DisplayName("흰색, 검은색 나이트 생성")
    void createKnight() {
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, Piece.WHITE_KNIGHT_SYMBOL);
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK, Piece.BLACK_KNIGHT_SYMBOL);
    }

    @Test
    @DisplayName("흰색, 검은색 룩 생성")
    void createRook() {
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Piece.WHITE_ROOK_SYMBOL);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK, Piece.BLACK_ROOK_SYMBOL);
    }

    @Test
    @DisplayName("흰색, 검은색 비숍 생성")
    void createBishop() {
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Piece.WHITE_BISHOP_SYMBOL);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Piece.BLACK_BISHOP_SYMBOL);
    }

    @Test
    @DisplayName("흰색, 검은색 퀸 생성")
    void createQueen() {
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Piece.WHITE_QUEEN_SYMBOL);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Piece.BLACK_QUEEN_SYMBOL);
    }

    @Test
    @DisplayName("흰색, 검은색 킹 생성")
    void createKing() {
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Piece.WHITE_KING_SYMBOL);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK, Piece.BLACK_KING_SYMBOL);
    }

    private void verifyPiece(final Piece piece, final String color, final char symbol){
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getSymbol()).isEqualTo(symbol);
    }

    @Test
    @DisplayName("흰색, 검은색 말 구분")
    void isBlackOrWhite() {
        Piece whitePiece = Piece.createWhitePawn();
        Piece blackPiece = Piece.createBlackPawn();
        assertThat(whitePiece.isWhite()).isEqualTo(true);
        assertThat(blackPiece.isBlack()).isEqualTo(true);
        assertThat(whitePiece.isBlack()).isEqualTo(false);
        assertThat(blackPiece.isWhite()).isEqualTo(false);
    }

}
