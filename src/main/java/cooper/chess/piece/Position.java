package cooper.chess.piece;

import cooper.chess.Board;

public class Position {
    private int yPos;
    private int xPos;

    public Position(String position) {
        this.yPos = setYPos(position);
        this.xPos = setXPos(position);
    }

    private int setXPos(String position) {
        return position.charAt(0) - 'a';
    }

    private int setYPos(String position) {
        return Board.BOARD_SIZE
                - Character.getNumericValue(position.charAt(1));
    }

    public int getyPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }
}
