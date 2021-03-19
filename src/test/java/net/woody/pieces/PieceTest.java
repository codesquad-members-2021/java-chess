package net.woody.pieces;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.woody.factories.PieceFactory.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("흰색과 검은색 체스말들이 정상적으로 생성되어야 한다")
    void createPieces() {
        assertAll(
                () -> verifyPieces(createWhitePawn(), createBlackPawn(), Type.PAWN),
                () -> verifyPieces(createWhiteKnight(), createBlackKnight(), Type.KNIGHT),
                () -> verifyPieces(createWhiteRook(), createBlackRook(), Type.ROOK),
                () -> verifyPieces(createWhiteBishop(), createBlackBishop(), Type.BISHOP),
                () -> verifyPieces(createWhiteQueen(), createBlackQueen(), Type.QUEEN),
                () -> verifyPieces(createWhiteKing(), createBlackKing(), Type.KING)
        );
    }

    @Test
    @DisplayName("빈 공간을 나타내는 Piece는 색상을 가지고 있지 않고 어떤 타입에도 속해서는 안된다")
    void createBlank() {
        Piece blank = getBlankInstance();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.getType()).isEqualTo(Type.NO_PIECE);
    }

    @Test
    @DisplayName("흰색으로 생성된 폰은 흰색이어야 하고, 검은색으로 생성했을 때는 검은색이어야 한다.")
    void checkPieceColor() {
        assertAll(
                () -> assertThat(createBlackPawn().isBlack()).isTrue(),
                () -> assertThat(createWhitePawn().isWhite()).isTrue()
        );
    }

    @Test
    @DisplayName("Collection 안에 있는 체스말들을 색상(흰색이 먼저), 점수(낮은 점수 먼저)에 따라 정렬해야한다.")
    void sortPiecesByScore() {
        List<Piece> pieces = getAllPieces();
        Collections.sort(pieces);
        assertThat(pieces).containsExactlyInAnyOrderElementsOf(getSortedPieces());
    }

    private List<Piece> getAllPieces() {
        return Stream.of(
                createBlackKnight(),
                createBlackRook(),
                createBlackKing(),
                createBlackBishop(),
                createBlackQueen(),
                createWhiteRook(),
                createWhiteKing(),
                createWhiteKnight(),
                createWhiteBishop(),
                createWhiteQueen()
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    private List<Piece> getSortedPieces() {
        return Stream.of(
                createWhiteKing(),
                createWhiteKnight(),
                createBlackBishop(),
                createWhiteRook(),
                createWhiteQueen(),
                createBlackKing(),
                createBlackKnight(),
                createWhiteBishop(),
                createBlackRook(),
                createBlackQueen()
        ).collect(Collectors.toCollection(ArrayList::new));
    }

    private void verifyPieces(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertThat(whitePiece.isWhite()).isTrue();
        assertThat(whitePiece.getType()).isEqualTo(type);

        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(blackPiece.getType()).isEqualTo(type);
    }

}
