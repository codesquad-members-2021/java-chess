package net.sky.pieces;

import static net.sky.pieces.Pawn.BLACK;
import static net.sky.pieces.Pawn.WHITE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import net.sky.pieces.Pawn.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {


  @Test
  @DisplayName("흰색 폰이 생성되어야 한다.")
  public void create() {
<<<<<<< HEAD:src/test/java/net/sky/pieces/PawnTest.java
    verifyPawn(Color.WHITE);
    verifyPawn(Color.BLACK);
=======
    verifyPawn(WHITE);
    verifyPawn(BLACK);
>>>>>>> d97d3ddf7e34cfeb0e80af61cfb04328fb978349:src/test/java/net/sky/chess/PawnTest.java
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