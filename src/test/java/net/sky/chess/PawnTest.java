package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

  @Test
  @DisplayName("흰색 폰이 생성되어야 한다.")
  public void create(){
    Pawn pawn = new Pawn("white");
    assertThat(pawn.getColor()).isEqualTo("white");

    Pawn pawn1 = new Pawn("black");
    assertThat(pawn1.getColor()).isEqualTo("black");
  }
}