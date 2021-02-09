package net.sky.pieces;

<<<<<<< HEAD

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
=======
public class Pawn {

  private final String color;
  public final static String WHITE = "white";
  public final static String BLACK = "black";

  public Pawn() {
    this.color = WHITE;
  }

  public Pawn(String color) {
    this.color = color;
  }

  public String getColor() {
>>>>>>> d97d3ddf7e34cfeb0e80af61cfb04328fb978349
    return color;
  }
}
