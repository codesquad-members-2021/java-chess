package net.sky.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import net.sky.pieces.Pawn.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {


  @Test
  @DisplayName("폰 색깔 확인")
  public void create() {
    verifyPawn(Color.WHITE);
    verifyPawn(Color.BLACK);
  }

  private void verifyPawn(final Color color) {
    Pawn pawn = new Pawn(color);
    assertThat(pawn.getColor()).isEqualTo(color);
  }


  @Test
  public void create_기본생성자() throws Exception {
    Pawn pawn = new Pawn();
    verifyPawn(pawn.getColor());
  }

}