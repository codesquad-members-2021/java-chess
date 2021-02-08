package mj.chess.test;


import mj.chess.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PawnTest {

    @Test
    @DisplayName("검정 폰 생성 테스트")
    public void create_test_color() {
        String colorOfTest = "black";
        verifyColorOfPawn(colorOfTest);
    }

    @Test
    @DisplayName("하얀 폰 생성 테스트")
    public void create_test_color_white() {
        String colorOfTest = "white";
        verifyColorOfPawn(colorOfTest);
    }

    public void verifyColorOfPawn(String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor(), is(equalTo(color)));
    }


}