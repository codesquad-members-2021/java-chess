package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import net.sky.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

  Board board;

  @BeforeEach
  public void initBoard(){
    board = new Board();
  }

  @Test
  @DisplayName("체스판 확인")
  public void create() throws Exception {
    verifyBoard(Pawn.WHITE, 1, 0);
    verifyBoard(Pawn.BLACK, 2, 1);
  }

  public void verifyBoard(final String color, int size, int idx){
    Pawn pawn = new Pawn(color);
    board.add(pawn);
    assertThat(board.size()).isEqualTo(size);
    assertThat(board.findPawn(idx)).isEqualTo(pawn);
  }

}