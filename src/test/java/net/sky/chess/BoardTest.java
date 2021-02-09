package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import net.sky.pieces.Pawn;
import net.sky.pieces.Pawn.Color;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  public void create() throws Exception {
    Board board = new Board();
    verifyBoard(board, Color.WHITE, 1, 0);
    verifyBoard(board, Color.BLACK, 2, 1);
  }

  private void verifyBoard(Board board, final Color color, int size, int idx) {
    Pawn pawn = new Pawn(color);
    board.add(pawn);
    assertThat(board.size()).isEqualTo(size);
    assertThat(board.findPawn(idx)).isEqualTo(pawn);
  }

}