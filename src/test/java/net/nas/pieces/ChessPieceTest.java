package net.nas.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ChessPieceTest {

    @Test
    @DisplayName("isWhite메서드는 흰색의 말에 대해 true를 리턴하고, 다른 색상인 경우엔 false를 리턴해야 합니다")
    void testIsWhite() {
        testAllCasesWithParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            assertThat(piece.isWhite()).isEqualTo(color == ColorOfChessPiece.WHITE);
        });
    }

    @Test
    @DisplayName("isBlack메서드는 검정색의 말에 대해 true를 리턴하고, 다른 색상인 경우엔 false를 리턴해야 합니다")
    void testIsBlack() {
        testAllCasesWithParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            assertThat(piece.isBlack()).isEqualTo(color == ColorOfChessPiece.BLACK);
        });
    }

    @Test
    @DisplayName("isBlank메서드는 Blank인 말에 대해 true를 리턴하고, 다른 색상인 경우엔 false를 리턴해야 합니다")
    void testIsBlank() {
        testAllCasesWithParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            assertThat(piece.isBlank()).isEqualTo(color == ColorOfChessPiece.BLANK);
        });
    }

    @Test
    @DisplayName("모든 흰색, 검정색 체스말을 생성할 수 있어야 합니다. " +
            "생성된 체스말이 올바른지는 표현문자를 이용해 검사합니다")
    void testCreationOfChessPieces() {
        testAllCasesWithParamFuncion((name, color) -> {
            ChessPiece piece = ChessPiece.createChessPiece(name, color);
            String expectedRepresentation = color.getRepresentationByColor(name);
            assertThat(piece.getRepresentation()).isEqualTo(expectedRepresentation);
        });
    }

    //체스말의 이름과 색상을 가지고 조합가능한 모든 경우에 대해, 패러미터 testMethod로 테스트합니다.
    private void testAllCasesWithParamFuncion(BiConsumer<NameOfChessPiece, ColorOfChessPiece> testMethod) {
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
        testSinglePiece(testPiece, NameOfChessPiece.PAWN, ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("createBlackPawn 팩토리 메서드는 BlackPawn을 생성할 수 있어야 합니다")
    void testCreateBlackPawn() {
        ChessPiece testPiece = ChessPiece.createBlackPawn();
        testSinglePiece(testPiece, NameOfChessPiece.PAWN, ColorOfChessPiece.BLACK);
    }

    @Test
    @DisplayName("createWhiteRook 팩토리 메서드는 WhiteRook을 생성할 수 있어야 합니다")
    void testCreateWhiteRook() {
        ChessPiece testPiece = ChessPiece.createWhiteRook();
        testSinglePiece(testPiece, NameOfChessPiece.ROOK, ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("createBlackRook 팩토리 메서드는 BlackRook을 생성할 수 있어야 합니다")
    void testCreateBlackRook() {
        ChessPiece testPiece = ChessPiece.createBlackRook();
        testSinglePiece(testPiece, NameOfChessPiece.ROOK, ColorOfChessPiece.BLACK);
    }

    @Test
    @DisplayName("createWhiteKnight 팩토리 메서드는 WhiteKnight을 생성할 수 있어야 합니다")
    void testCreateWhiteKnight() {
        ChessPiece testPiece = ChessPiece.createWhiteKnight();
        testSinglePiece(testPiece, NameOfChessPiece.KNIGHT, ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("createBlackKnight 팩토리 메서드는 BlackKnight을 생성할 수 있어야 합니다")
    void testCreateBlackKnight() {
        ChessPiece testPiece = ChessPiece.createBlackKnight();
        testSinglePiece(testPiece, NameOfChessPiece.KNIGHT, ColorOfChessPiece.BLACK);
    }

    @Test
    @DisplayName("createWhiteBishop 팩토리 메서드는 WhiteBishop을 생성할 수 있어야 합니다")
    void testCreateWhiteBishop() {
        ChessPiece testPiece = ChessPiece.createWhiteBishop();
        testSinglePiece(testPiece, NameOfChessPiece.BISHOP, ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("createBlackBishop 팩토리 메서드는 BlackBishop을 생성할 수 있어야 합니다")
    void testCreateBlackBishop() {
        ChessPiece testPiece = ChessPiece.createBlackBishop();
        testSinglePiece(testPiece, NameOfChessPiece.BISHOP, ColorOfChessPiece.BLACK);
    }

    @Test
    @DisplayName("createWhiteQueen 팩토리 메서드는 WhiteQueen을 생성할 수 있어야 합니다")
    void testCreateWhiteQueen() {
        ChessPiece testPiece = ChessPiece.createWhiteQueen();
        testSinglePiece(testPiece, NameOfChessPiece.QUEEN, ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("createBlackQueen 팩토리 메서드는 BlackQueen을 생성할 수 있어야 합니다")
    void testCreateBlackQueen() {
        ChessPiece testPiece = ChessPiece.createBlackQueen();
        testSinglePiece(testPiece, NameOfChessPiece.QUEEN, ColorOfChessPiece.BLACK);
    }

    @Test
    @DisplayName("createWhiteKing 팩토리 메서드는 WhiteKing을 생성할 수 있어야 합니다")
    void testCreateWhiteKing() {
        ChessPiece testPiece = ChessPiece.createWhiteKing();
        testSinglePiece(testPiece, NameOfChessPiece.KING, ColorOfChessPiece.WHITE);
    }

    @Test
    @DisplayName("createBlackKing 팩토리 메서드는 BlackKing을 생성할 수 있어야 합니다")
    void testCreateBlackKing() {
        ChessPiece testPiece = ChessPiece.createBlackKing();
        testSinglePiece(testPiece, NameOfChessPiece.KING, ColorOfChessPiece.BLACK);
    }

    private void testSinglePiece(ChessPiece testPiece, NameOfChessPiece name, ColorOfChessPiece color) {
        assertThat(testPiece.getRepresentation())
                .isEqualTo(color.getRepresentationByColor(name));
    }
}
