package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import net.sky.pieces.Pawn;
import net.sky.pieces.Pawn.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
  Board board;

  @BeforeEach
  void initBoard(){
    board = new Board();
  }

  @Test
  public void create() throws Exception {
    verifyBoard(Color.WHITE, 1, 0);
    verifyBoard(Color.BLACK, 2, 1);
  }

  private void verifyBoard(final Color color, int size, int idx) {
    Pawn pawn = new Pawn(color);
    board.add(pawn);
    assertThat(board.size()).isEqualTo(size);
    assertThat(board.findPawn(idx)).isEqualTo(pawn);
  }

}