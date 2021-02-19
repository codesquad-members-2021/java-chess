package net.nas.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChessPieceTest {

    @Test
    @DisplayName("모든 흰색, 검정색 체스말을 생성할 수 있어야 합니다. " +
            "생성된 체스말이 올바른지는 표현문자를 이용해 검사합니다")
    void testCreationOfChessPieces() {
        //모든 체스말 이름에 대해서 반복합니다. PAWN > ROOK > KNIGHT > ...
        for (NameOfChessPiece name : NameOfChessPiece.values()) {
            //모든 체스말의 색상에 대해서 반복합니다. WHITE > BLACK > BLANK
            for (ColorOfChessPiece color : ColorOfChessPiece.values()) {
                ChessPiece piece = createPiece(name, color);
                String expectedRepresentation = color.getRepresentationByColor(name.getRepresentation());
                assertThat(piece.getRepresentation()).isEqualTo(expectedRepresentation);
            }
        }
    }

    private ChessPiece createPiece(NameOfChessPiece name, ColorOfChessPiece color) {
        return ChessPiece.createChessPiece(name, color);
    }

    @Test
    @DisplayName("createWhitePawn 팩토리 메서드는 WhitePawn을 생성할 수 있어야 합니다")
    void testCreateWhitePawn() {
        ChessPiece testPiece = ChessPiece.createWhitePawn();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE.getRepresentationByColor(NameOfChessPiece.PAWN.getRepresentation()));
    }

    @Test
    @DisplayName("createBlackPawn 팩토리 메서드는 BlackPawn을 생성할 수 있어야 합니다")
    void testCreateBlackPawn() {
        ChessPiece testPiece = ChessPiece.createBlackPawn();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK.getRepresentationByColor(NameOfChessPiece.PAWN.getRepresentation()));
    }

    @Test
    @DisplayName("createWhiteRook 팩토리 메서드는 WhiteRook을 생성할 수 있어야 합니다")
    void testCreateWhiteRook() {
        ChessPiece testPiece = ChessPiece.createWhiteRook();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE.getRepresentationByColor(NameOfChessPiece.ROOK.getRepresentation()));
    }

    @Test
    @DisplayName("createBlackRook 팩토리 메서드는 BlackRook을 생성할 수 있어야 합니다")
    void testCreateBlackRook() {
        ChessPiece testPiece = ChessPiece.createBlackRook();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK.getRepresentationByColor(NameOfChessPiece.ROOK.getRepresentation()));
    }

    @Test
    @DisplayName("createWhiteKnight 팩토리 메서드는 WhiteKnight을 생성할 수 있어야 합니다")
    void testCreateWhiteKnight() {
        ChessPiece testPiece = ChessPiece.createWhiteKnight();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE.getRepresentationByColor(NameOfChessPiece.KNIGHT.getRepresentation()));
    }

    @Test
    @DisplayName("createBlackKnight 팩토리 메서드는 BlackKnight을 생성할 수 있어야 합니다")
    void testCreateBlackKnight() {
        ChessPiece testPiece = ChessPiece.createBlackKnight();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK.getRepresentationByColor(NameOfChessPiece.KNIGHT.getRepresentation()));
    }

    @Test
    @DisplayName("createWhiteBishop 팩토리 메서드는 WhiteBishop을 생성할 수 있어야 합니다")
    void testCreateWhiteBishop() {
        ChessPiece testPiece = ChessPiece.createWhiteBishop();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE.getRepresentationByColor(NameOfChessPiece.BISHOP.getRepresentation()));
    }

    @Test
    @DisplayName("createBlackBishop 팩토리 메서드는 BlackBishop을 생성할 수 있어야 합니다")
    void testCreateBlackBishop() {
        ChessPiece testPiece = ChessPiece.createBlackBishop();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK.getRepresentationByColor(NameOfChessPiece.BISHOP.getRepresentation()));
    }

    @Test
    @DisplayName("createWhiteQueen 팩토리 메서드는 WhiteQueen을 생성할 수 있어야 합니다")
    void testCreateWhiteQueen() {
        ChessPiece testPiece = ChessPiece.createWhiteQueen();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE.getRepresentationByColor(NameOfChessPiece.QUEEN.getRepresentation()));
    }

    @Test
    @DisplayName("createBlackQueen 팩토리 메서드는 BlackQueen을 생성할 수 있어야 합니다")
    void testCreateBlackQueen() {
        ChessPiece testPiece = ChessPiece.createBlackQueen();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK.getRepresentationByColor(NameOfChessPiece.QUEEN.getRepresentation()));
    }

    @Test
    @DisplayName("createWhiteKing 팩토리 메서드는 WhiteKing을 생성할 수 있어야 합니다")
    void testCreateWhiteKing() {
        ChessPiece testPiece = ChessPiece.createWhiteKing();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.WHITE.getRepresentationByColor(NameOfChessPiece.KING.getRepresentation()));
    }

    @Test
    @DisplayName("createBlackKing 팩토리 메서드는 BlackKing을 생성할 수 있어야 합니다")
    void testCreateBlackKing() {
        ChessPiece testPiece = ChessPiece.createBlackKing();
        assertThat(testPiece.getRepresentation())
                .isEqualTo(ColorOfChessPiece.BLACK.getRepresentationByColor(NameOfChessPiece.KING.getRepresentation()));
    }
}
