package net.nas.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ChessPieceTest {

    @Test
    @DisplayName("isWhite메서드는 흰색의 말에 대해 true를 리턴하고, 다른 색상인 경우엔 false를 리턴해야 합니다")
    void testIsWhite() {
        testAllCasesWidhParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            if (color == ColorOfChessPiece.WHITE)
                assertThat(piece.isWhite()).isTrue();
            else assertThat(piece.isWhite()).isFalse();
        });
    }

    @Test
    @DisplayName("isBlack메서드는 검정색의 말에 대해 true를 리턴하고, 다른 색상인 경우엔 false를 리턴해야 합니다")
    void testIsBlack() {
        testAllCasesWidhParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            if (color == ColorOfChessPiece.BLACK)
                assertThat(piece.isBlack()).isTrue();
            else assertThat(piece.isBlack()).isFalse();
        });
    }

    @Test
    @DisplayName("isBlank메서드는 Blank인 말에 대해 true를 리턴하고, 다른 색상인 경우엔 false를 리턴해야 합니다")
    void testIsBlank() {
        testAllCasesWidhParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            if (color == ColorOfChessPiece.BLANK)
                assertThat(piece.isBlank()).isTrue();
            else assertThat(piece.isBlank()).isFalse();
        });
    }

    @Test
    @DisplayName("모든 흰색, 검정색 체스말을 생성할 수 있어야 합니다. " +
            "생성된 체스말이 올바른지는 표현문자를 이용해 검사합니다")
    void testCreationOfChessPieces() {
        testAllCasesWidhParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            String expectedRepresentation = color.getRepresentationByColor(name);
            assertThat(piece.getRepresentation()).isEqualTo(expectedRepresentation);
        });
    }

    //체스말의 이름과 색상을 가지고 조합가능한 모든 경우에 대해, 패러미터 testMethod로 테스트합니다.
    private void testAllCasesWidhParamFuncion(BiConsumer<NameOfChessPiece, ColorOfChessPiece> testMethod) {
        for (NameOfChessPiece name : NameOfChessPiece.values()) {
            for (ColorOfChessPiece color : ColorOfChessPiece.values()) {
                testMethod.accept(name, color);
            }
        }
    }

    @Test
    @DisplayName("createWhitePawn 팩토리 메서드는 WhitePawn을 생성할 수 있어야 합니다")
    void testCreateWhitePawn() {
        ChessPiece testPiece = ChessPiece.createWhitePawn();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE
                        .getRepresentationByColor(NameOfChessPiece.PAWN));
    }

    @Test
    @DisplayName("createBlackPawn 팩토리 메서드는 BlackPawn을 생성할 수 있어야 합니다")
    void testCreateBlackPawn() {
        ChessPiece testPiece = ChessPiece.createBlackPawn();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK
                        .getRepresentationByColor(NameOfChessPiece.PAWN));
    }

    @Test
    @DisplayName("createWhiteRook 팩토리 메서드는 WhiteRook을 생성할 수 있어야 합니다")
    void testCreateWhiteRook() {
        ChessPiece testPiece = ChessPiece.createWhiteRook();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE
                        .getRepresentationByColor(NameOfChessPiece.ROOK));
    }

    @Test
    @DisplayName("createBlackRook 팩토리 메서드는 BlackRook을 생성할 수 있어야 합니다")
    void testCreateBlackRook() {
        ChessPiece testPiece = ChessPiece.createBlackRook();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK
                        .getRepresentationByColor(NameOfChessPiece.ROOK));
    }

    @Test
    @DisplayName("createWhiteKnight 팩토리 메서드는 WhiteKnight을 생성할 수 있어야 합니다")
    void testCreateWhiteKnight() {
        ChessPiece testPiece = ChessPiece.createWhiteKnight();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE
                        .getRepresentationByColor(NameOfChessPiece.KNIGHT));
    }

    @Test
    @DisplayName("createBlackKnight 팩토리 메서드는 BlackKnight을 생성할 수 있어야 합니다")
    void testCreateBlackKnight() {
        ChessPiece testPiece = ChessPiece.createBlackKnight();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK
                        .getRepresentationByColor(NameOfChessPiece.KNIGHT));
    }

    @Test
    @DisplayName("createWhiteBishop 팩토리 메서드는 WhiteBishop을 생성할 수 있어야 합니다")
    void testCreateWhiteBishop() {
        ChessPiece testPiece = ChessPiece.createWhiteBishop();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE
                        .getRepresentationByColor(NameOfChessPiece.BISHOP));
    }

    @Test
    @DisplayName("createBlackBishop 팩토리 메서드는 BlackBishop을 생성할 수 있어야 합니다")
    void testCreateBlackBishop() {
        ChessPiece testPiece = ChessPiece.createBlackBishop();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK
                        .getRepresentationByColor(NameOfChessPiece.BISHOP));
    }

    @Test
    @DisplayName("createWhiteQueen 팩토리 메서드는 WhiteQueen을 생성할 수 있어야 합니다")
    void testCreateWhiteQueen() {
        ChessPiece testPiece = ChessPiece.createWhiteQueen();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE
                        .getRepresentationByColor(NameOfChessPiece.QUEEN));
    }

    @Test
    @DisplayName("createBlackQueen 팩토리 메서드는 BlackQueen을 생성할 수 있어야 합니다")
    void testCreateBlackQueen() {
        ChessPiece testPiece = ChessPiece.createBlackQueen();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK
                        .getRepresentationByColor(NameOfChessPiece.QUEEN));
    }

    @Test
    @DisplayName("createWhiteKing 팩토리 메서드는 WhiteKing을 생성할 수 있어야 합니다")
    void testCreateWhiteKing() {
        ChessPiece testPiece = ChessPiece.createWhiteKing();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE
                        .getRepresentationByColor(NameOfChessPiece.KING));
    }

    @Test
    @DisplayName("createBlackKing 팩토리 메서드는 BlackKing을 생성할 수 있어야 합니다")
    void testCreateBlackKing() {
        ChessPiece testPiece = ChessPiece.createBlackKing();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK
                        .getRepresentationByColor(NameOfChessPiece.KING));
    }
}
