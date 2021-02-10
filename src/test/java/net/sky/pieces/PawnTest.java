package net.sky.pieces;

import static net.sky.pieces.Pawn.BLACK;
import static net.sky.pieces.Pawn.WHITE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {


  @Test
  @DisplayName("흰색 폰이 생성되어야 한다.")
  public void create() {
    verifyPawn(WHITE);
    verifyPawn(BLACK);
  }

  private void verifyPawn(final String color) {
    Pawn pawn = new Pawn(color);
    assertThat(pawn.getColor()).isEqualTo(color);
  }


  @Test
  public void create_기본생성자() throws Exception {
    Pawn pawn = new Pawn();
    verifyPawn(pawn.getColor());
  }

}