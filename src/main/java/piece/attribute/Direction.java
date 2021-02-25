package piece.attribute;

public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private int xMove;
    private int yMove;

    Direction(int xMove, int yMove) {
        this.xMove = xMove;
        this.yMove = yMove;
    }

    public int getxMove() {
        return xMove;
    }

    public int getyMove() {
        return yMove;
    }
}
