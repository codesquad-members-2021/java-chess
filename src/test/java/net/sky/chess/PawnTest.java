package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

  @Test
  @DisplayName("흰색 폰이 생성되어야 한다")
  public void create(){
    verifyPawn("white");
    verifyPawn("black");
  }

  private void verifyPawn(String color) {
    Pawn pawn1 = new Pawn(color);
    assertThat(pawn1.getColor()).isEqualTo(color);
  }
}