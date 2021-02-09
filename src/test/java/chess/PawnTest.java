package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    @DisplayName("Pawn 클래스 인스턴스의 String color를 비교한다.")
    public void compare(){
        String[] colors = {"white,black"};
        for(String color : colors){
            assertEquals(new Pawn(color).getColor(),color);
        }
    }
}