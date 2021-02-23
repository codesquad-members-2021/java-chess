package chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    Position position;

    @BeforeEach
    void positionInit(){
        int testPositionIndex = 1;
        position = new Position(testPositionIndex, testPositionIndex);
    }

    @Test
    void piecesPointSort() {
        List<Piece> pieces = new ArrayList<>();

        addPiece(pieces);

        Collections.sort(pieces);
        assertThat(pieces.toString()).isEqualTo("[Q, R, B, N, P, K]");

    }

    void addPiece(List<Piece> collection) {
        collection.add(Piece.createBlackPawn(position));
        collection.add(Piece.createBlackRook(position));
        collection.add(Piece.createBlackKnight(position));
        collection.add(Piece.createBlackBishop(position));
        collection.add(Piece.createBlackQueen(position));
        collection.add(Piece.createBlackKing(position));
    }

    @Test
    @DisplayName("체스말이 정상적으로 생성되는지 확인한다.")
    public void createPieces() {
        Piece blank = Piece.createBlank(position);

        assertAll(
                () -> verifyWhitePiece(Piece.createWhitePawn(position), Type.PAWN),
                () -> verifyBlackPiece(Piece.createBlackPawn(position), Type.PAWN),

                () -> verifyWhitePiece(Piece.createWhiteRook(position), Type.ROOK),
                () -> verifyBlackPiece(Piece.createBlackRook(position), Type.ROOK),

                () -> verifyWhitePiece(Piece.createWhiteKnight(position), Type.KNIGHT),
                () -> verifyBlackPiece(Piece.createBlackKnight(position), Type.KNIGHT),

                () -> verifyWhitePiece(Piece.createWhiteBishop(position), Type.BISHOP),
                () -> verifyBlackPiece(Piece.createBlackBishop(position), Type.BISHOP),

                () -> verifyWhitePiece(Piece.createWhiteQueen(position), Type.QUEEN),
                () -> verifyBlackPiece(Piece.createBlackQueen(position), Type.QUEEN),

                () -> verifyWhitePiece(Piece.createWhiteKing(position), Type.KING),
                () -> verifyBlackPiece(Piece.createBlackKing(position), Type.KING),

                () -> assertThat(blank.isWhite()).isEqualTo(false),
                () -> assertThat(blank.isBlack()).isEqualTo(false),
                () -> assertThat(blank.getColor()).isEqualTo(Color.NO_COLOR),
                () -> assertThat(blank.getRepresentation()).isEqualTo(Type.BLANK.getWhiteRepresentation())
        );
    }

    private void verifyWhitePiece(Piece piece, Type type) {
        assertAll(
                () -> assertThat(piece.isWhite()).isEqualTo(true),
                () -> assertThat(piece.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(piece.getRepresentation()).isEqualTo(type.getWhiteRepresentation())
        );
    }

    private void verifyBlackPiece(Piece piece, Type type) {
        assertAll(
                () -> assertThat(piece.isBlack()).isEqualTo(true),
                () -> assertThat(piece.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(piece.getRepresentation()).isEqualTo(type.getBlackRepresentation())
        );
    }

}
