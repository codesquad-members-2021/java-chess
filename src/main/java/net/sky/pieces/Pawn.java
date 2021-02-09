package net.sky.pieces;


public class Pawn {

  private final Color color;

  public enum Color {WHITE, BLACK}

  public Pawn() {
    this.color = Color.WHITE;
  }

  public Pawn(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
