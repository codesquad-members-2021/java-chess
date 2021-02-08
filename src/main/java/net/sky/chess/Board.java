package net.sky.chess;

import java.util.ArrayList;
import java.util.List;
import net.sky.pieces.Pawn;

public class Board {

  private List<Pawn> pawns;

  public Board() {
    pawns = new ArrayList<>();
  }

  public void add(Pawn pawn) {
    pawns.add(pawn);
  }

  public int size(){
    return pawns.size();
  }

  public Pawn findPawn(int idx){
    return pawns.get(idx);
  }
}
