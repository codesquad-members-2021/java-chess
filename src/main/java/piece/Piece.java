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

    abstract boolean isInValidMoveRange(Position after);

    public abstract boolean isMovable(Position after);

    Direction direction(Position after) {
        Optional<Direction> optionalDirection = movableDirections().stream()
                .filter(direction -> (after.x() - position.x()) == direction.xMove())
                .filter(direction -> (after.y() - position.y()) == direction.yMove())
                .findFirst();
        return optionalDirection.orElse(Direction.INVALID);
    }

    String getErrorMessage(Position after) {
        return getType().name() + " can't move from "
                + position.getFile() + position.getRank() + " to "
                + after.getFile() + after.getRank();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position after) {
        this.position = after;
    }

    public boolean isSameColor(Piece piece) {
        if (!((isWhite() && piece.isWhite()) || (isBlack() && piece.isBlack()))) {
            return false;
        }
        throw new PositionNotMovableException("Cannot move to the same team's square.");
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

    public boolean isPawn() {
        return type == Type.PAWN;
    }

    public boolean isSameColorAs(Color color) {
        return this.color == color;
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

