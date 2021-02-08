import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // 테스트 메서드 이름의 언더바(_)를 지워준다
public class PawnTest {

    @Disabled
    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다") // @DisplayNameGeneration보다 우선이다.
    void create_white_and_black_pawns() {      // JUnit5부터 public 생략 가능하다(리플렉션? 때문)
        final String white = "white";
        final String black = "black";

        assertAll(                             // 여러 개의 assert문을 모두 실행해서 실패한 모든 assert문을 알려준다.
                () -> verifyPawn(white),
                () -> verifyPawn(black)
        );
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color           // 기대값
                , pawn.getColor()    // 실제값
                , () -> color + "를 인자로 생성된 Pawn인스턴스는 color속성의 값으로 " + color + "를 가지고 있어야 한다"); // 마지막 인자값을 람다식으로 작성했을 경우, 테스트 실패시에만 연산한다.
    }

    @Test
    @DisplayName("기본생성자로 흰색 폰이 생성되어야 한다.")
    void create_default_constructor() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor());
    }
}
