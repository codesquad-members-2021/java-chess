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
}
