package entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;
import net.honux.chess.entity.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    void createWhitePawn() {
        Pawn pawn = new Pawn('p', Color.WHITE, new Pointer('a', 2));
        Color expectedColor = Color.WHITE;
        Color result = pawn.getColor();
        assertThat(result).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("검은색 폰이 생성되어야 한다.")
    void createBlackPawn() {
        Pawn pawn = new Pawn('p', Color.BLACK, new Pointer('a', 2));
        Color expectedColor = Color.BLACK;
        Color result = pawn.getColor();
        assertThat(result).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("폰의 이름이 정상적으로 등록되어야 한다.")
    void setPawnName() {
        Pawn whitePawn = new Pawn('p', Color.WHITE, new Pointer('a', 2));
        Pawn blackPawn = new Pawn('p', Color.BLACK, new Pointer('a', 2));
        assertThat(whitePawn.getName()).isEqualTo('p');
        assertThat(blackPawn.getName()).isEqualTo('p');
    }

    @Test
    @DisplayName("폰의 시작 포인트가 정상적으로 등록되어야 한다.")
    void setPawnPointer() {
        Pawn pawn = new Pawn('p', Color.WHITE, new Pointer('a', 2));
        assertThat(pawn.getCurrentPointer().toString()).isEqualTo("a,2");
    }
}
