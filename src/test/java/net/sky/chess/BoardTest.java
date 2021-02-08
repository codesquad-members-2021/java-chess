package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import net.sky.pieces.Pawn;
import org.junit.jupiter.api.Test;

class BoardTest {
  @Test
  public void create() throws Exception{
    Board board = new Board();

    Pawn white = new Pawn(Pawn.WHITE);
    board.add(white);
    assertThat(board.size()).isEqualTo(1);
    assertThat(board.findPawn(0)).isEqualTo(white);

    Pawn black = new Pawn(Pawn.BLACK);
    board.add(black);
    assertThat(board.size()).isEqualTo(2);
    assertThat(board.findPawn(1)).isEqualTo(black);

  }
}