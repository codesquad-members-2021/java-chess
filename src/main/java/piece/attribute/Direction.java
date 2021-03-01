package piece.attribute;

import java.util.*;

import static chess.Board.BOARD_SIZE;

public enum Direction {
    NORTH(0, 1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    SOUTHEAST(1, -1),
    SOUTH(0, -1),
    SOUTHWEST(-1, -1),
    WEST(-1, 0),
    NORTHWEST(-1, 1),
    ENN(1, 2),
    WNN(-1, 2),
    ESS(1, -2),
    WSS(-1, -2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1),
    INVALID(BOARD_SIZE, BOARD_SIZE);

    private final int xMove;
    private final int yMove;

    Direction(int xMove, int yMove) {
        this.xMove = xMove;
        this.yMove = yMove;
    }

    public int xMove() {
        return xMove;
    }

    public int yMove() {
        return yMove;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(ENN, WNN, ESS, WSS, EEN, EES, WWN, WWS);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }
}

