package net.sky.chess;

public class Pawn {

  private final String color;
  final static String WHITE = "white";
  final static String BLACK = "black";

  public Pawn() {
    this.color = WHITE;
  }

  public Pawn(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }
}
