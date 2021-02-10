package pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PawnTest {

    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"white", "black", "green"})
    public void create(String color) {
        if(color.equals("white") || color.equals("black")){
            verifyPawn(color);
        } else {
            assertThatIllegalArgumentException().isThrownBy(()-> verifyPawn(color));
            System.out.println("잘못된 색 입력하셨습니다");
        }


    }

    private void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}
