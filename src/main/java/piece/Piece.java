package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;
import java.util.Objects;

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

    public boolean isMovable(Position after) {
        return movableDirections().contains(direction(after))
                && isInValidMoveRange(after) && after.isValid();
    }

    boolean isInValidMoveRange(Position after) {
        return after.x() - this.getPosition().x() == this.direction(after).xMove()
                && after.y() - this.getPosition().y() ==this.direction(after).yMove();
    }

    public void setPosition(Position after) {
        this.position = after;
    }

    public Position getPosition() {
        return position;
    }

    boolean east(Position after) {
        return position.x() < after.x();
    }

    boolean west(Position after) {
        return position.x() > after.x();
    }

    boolean north(Position after) {
        return position.y() < after.y();
    }

    boolean south(Position after) {
        return position.y() > after.y();
    }

    public Direction direction(Position after) {
        if (position.x() == after.x() && south(after)) {
            return Direction.SOUTH;
        }
        if (position.x() == after.x() && north(after)) {
            return Direction.NORTH;
        }
        if (east(after) && position.y() == after.y()) {
            return Direction.EAST;
        }
        if (west(after) && position.y() == after.y()) {
            return Direction.WEST;
        }
        if (south(after) && west(after)) {
            return Direction.SOUTHWEST;
        }
        if (south(after) && east(after)) {
            return Direction.SOUTHEAST;
        }
        if (north(after) && east(after)) {
            return Direction.NORTHEAST;
        }
        if (north(after) && west(after)) {
            return Direction.NORTHWEST;
        }
        return Direction.SAME;
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

