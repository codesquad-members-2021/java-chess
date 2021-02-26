package piece;

import chess.Position;
import piece.attribute.*;

import java.util.*;

public abstract class Piece implements Comparable<Piece> {
    private final Color color;
    private final Type type;
    private Position position;

    protected Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    abstract List<Direction> movableDirections();

    public Direction direction(Position after) {
        Optional<Direction> optionalDirection = movableDirections().stream()
                .filter(direction -> (after.x() - position.x()) == direction.xMove())
                .filter(direction -> (after.y() - position.y() == direction.yMove()))
                .findFirst();
        return optionalDirection.orElse(Direction.INVALID);
    }

    public boolean isMovable(Position after) {
        if (movableDirections().contains(direction(after))
                && isInValidMoveRange(after) && after.isValid()) {
            return true;
        }
        printErrorMessage(after);
        return false;
    }

    private void printErrorMessage(Position after) {
        System.err.println(getType().name() + " can't move from "
                + position.getFile() + position.getRank() + " to "
                + after.getFile() + after.getRank());
    }

    boolean isInValidMoveRange(Position after) {
        return ((after.x() - getPosition().x()) == direction(after).xMove())
                && ((after.y() - getPosition().y()) == direction(after).yMove());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position after) {
        this.position = after;
    }

    public boolean isSameColor(Piece piece) {
        if (isWhite() && piece.isWhite()) {
            return true;
        }
        return isBlack() && piece.isBlack();
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return isWhite() ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public double getPoint() {
        return type.getDefaultPoint();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            return color == ((Piece) obj).color && type == ((Piece) obj).type;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public int compareTo(Piece piece) {
        return (int) (piece.getPoint() - this.getPoint());
    }

    @Override
    public String toString() {
        return getRepresentation() + "";
    }
}

