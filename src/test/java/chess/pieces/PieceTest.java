package chess.pieces;

import chess.Position;
import chess.pieces.Piece.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PieceTest {

    @DisplayName("기물의 representation이 올바르게 지정되었는지 확인한다.")
    @Test
    void getRepresentationPerPiece() {
        assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

    @DisplayName("기물의 타입과 color가 올바르게 지정되었는지 확인한다.")
    @Test
    void createPiece() {
        verifyPiece(Piece.createWhitePawn(new Position("a1")),
                Piece.createBlackPawn(new Position("a2")), Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(new Position("b1")),
                Piece.createBlackKnight(new Position("b2")), Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(new Position("c1")),
                Piece.createBlackRook(new Position("c2")), Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(new Position("d1")),
                Piece.createBlackBishop(new Position("d2")), Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(new Position("e1")),
                Piece.createBlackQueen(new Position("e2")), Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(new Position("f1")),
                Piece.createBlackKing(new Position("f2")), Type.KING);
    }

    @DisplayName("빈 기물의 속성이 올바르게 지정되었는지 확인한다.")
    @Test
    void createBlank() {
        Piece blank = Piece.createBlank(new Position("a1"));
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    @DisplayName("기물의 position이 올바르게 지정되었는지 확인한다.")
    @Test
    void getPosition() {
        Position position = new Position("a1");
        Piece piece = Piece.createBlackBishop(position);
        assertThat(piece.getPosition()).isEqualTo(position);
    }

    void verifyPiece(Piece whitePiece, Piece blackPiece, Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }
}