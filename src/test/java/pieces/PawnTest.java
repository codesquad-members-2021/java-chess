package pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PawnTest {


    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"white", "black"})
    public void create(String color) {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
    }
}
