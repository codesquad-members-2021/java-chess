package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

  @Test
  @DisplayName("흰색 폰이 생성되어야 한다.")
  public void create(){
    verifyPawn("white");
    verifyPawn("black");
  }

  private void verifyPawn(final String color) {
    Pawn pawn = new Pawn(color);
    assertThat(pawn.getColor()).isEqualTo(color);
  }

}