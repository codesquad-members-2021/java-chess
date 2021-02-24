import net.sanhee.pieces.Piece;
import net.sanhee.pieces.PieceFactory;
import net.sanhee.pieces.property.UnitColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("흰색 폰(소문자 p)이(가) 생성되어야 한다.")
    void createWhitePawn() {
        Piece pawn = PieceFactory.createPawn(UnitColor.WHITE);
        verifyPawn(pawn.getRepresentation(), UnitColor.WHITE);
    }

    @Test
    @DisplayName("검은색 폰(대문자 P)이(가) 생성되어야 한다.")
    void createBlackPawn() {
        Piece pawn = PieceFactory.createPawn(UnitColor.BLACK);
        verifyPawn(pawn.getRepresentation(), UnitColor.BLACK);
    }

    void verifyPawn(final char representation, final UnitColor expectColor) {
        Piece pawn = PieceFactory.createPawn(expectColor);
        assertThat(pawn.getColor()).isEqualTo(expectColor);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("블랙 색상 테스트")
    void checkBlack() {
        Piece pawn = PieceFactory.createPawn(UnitColor.BLACK);
        Piece king = PieceFactory.createKing(UnitColor.BLACK);
        assertThat(pawn.isBlack()).isEqualTo(true);
        assertThat(king.isBlack()).isEqualTo(true);
    }

    @Test
    @DisplayName("화이트 색상 테스트")
    void checkWhite() {
        Piece pawn = PieceFactory.createPawn(UnitColor.WHITE);
        Piece king = PieceFactory.createKing(UnitColor.WHITE);
        assertThat(pawn.isWhite()).isEqualTo(true);
        assertThat(king.isWhite()).isEqualTo(true);
    }
}