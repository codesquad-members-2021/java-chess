package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.honux.chess.entity.pieces.Piece.*;
import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("Pawn 이 정상적으로 생성되어야 한다.")
    void createPawn() {
        Piece whitePawn = createWhitePawn();
        Piece blackPawn = createBlackPawn();
        Assertions.assertAll(
                () -> assertThat(whitePawn.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whitePawn.getRepresentation()).isEqualTo('p'),
                () -> assertThat(blackPawn.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackPawn.getRepresentation()).isEqualTo('P')
        );

    }

    @Test
    @DisplayName("Knight 가 정상적으로 생성되어야 한다.")
    void createKnight() {
        Piece whiteKnight = createWhiteKnight();
        Piece blackKnight = createBlackKnight();
        Assertions.assertAll(
                () -> assertThat(whiteKnight.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whiteKnight.getRepresentation()).isEqualTo('n'),
                () -> assertThat(blackKnight.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackKnight.getRepresentation()).isEqualTo('N')
        );

    }

    @Test
    @DisplayName("Bishop 이 정상적으로 생성되어야 한다.")
    void createBishop() {
        Piece whiteBishop = createWhiteBishop();
        Piece blackBishop = createBlackBishop();
        Assertions.assertAll(
                () -> assertThat(whiteBishop.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whiteBishop.getRepresentation()).isEqualTo('b'),
                () -> assertThat(blackBishop.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackBishop.getRepresentation()).isEqualTo('B')
        );

    }

    @Test
    @DisplayName("Rook 이 정상적으로 생성되어야 한다.")
    void createRook() {
        Piece whiteRook = createWhiteRook();
        Piece blackRook = createBlackRook();
        Assertions.assertAll(
                () -> assertThat(whiteRook.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whiteRook.getRepresentation()).isEqualTo('r'),
                () -> assertThat(blackRook.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackRook.getRepresentation()).isEqualTo('R')
        );

    }

    @Test
    @DisplayName("Queen 이 정상적으로 실행되어야 한다.")
    void createQueen() {
        Piece whiteQueen = createWhiteQueen();
        Piece blackQueen = createBlackQueen();
        Assertions.assertAll(
                () -> assertThat(whiteQueen.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whiteQueen.getRepresentation()).isEqualTo('q'),
                () -> assertThat(blackQueen.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackQueen.getRepresentation()).isEqualTo('Q')
        );

    }

    @Test
    @DisplayName("king 이 정상적으로 생성되어야 한다.")
    void createKing() {
        Piece whiteKing = createWhiteKing();
        Piece blackKing = createBlackKing();
        Assertions.assertAll(
                () -> assertThat(whiteKing.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whiteKing.getRepresentation()).isEqualTo('k'),
                () -> assertThat(blackKing.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackKing.getRepresentation()).isEqualTo('K')
        );

    }

    @Test
    @DisplayName("Blank Piece 가 정상적으로 생성되어야 한다.")
    void createBlankPiece() {
        Piece blankPiece = createBlank();
        assertThat(blankPiece.getRepresentation()).isEqualTo('.');
    }

    @Test
    @DisplayName("isBlack() / isWhite() 가 정상적으로 작동하는지 확인한다.")
    void testSeparateColorMethod() {
        Piece whitePawn = createWhitePawn();
        Piece blackPawn = createBlackPawn();
        Assertions.assertAll(
                ()->assertThat(whitePawn.isWhite()).isEqualTo(true),
                ()->assertThat(blackPawn.isBlack()).isEqualTo(true)
        );
    }

}
