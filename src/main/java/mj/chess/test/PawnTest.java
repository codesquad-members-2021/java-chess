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
    public void create_test_color_black() {
        Pawn pawn = new Pawn("black");
        assertThat(pawn.getColor(), is(equalTo("black")));
    }

    @Test
    @DisplayName("하얀 폰 생성 테스트")
    public void create_test_color_white() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor(), is(equalTo("white")));
    }
}