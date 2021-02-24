package cooper.chess;

import cooper.chess.piece.*;
import java.util.*;

import static cooper.chess.utils.StringUtils.*;

public class Board {
    private static final int BOARD_SIZE = 8;

    private final PieceGroup pieceGroup;

    public Board() {
        this.pieceGroup = new PieceGroup();
    }

    public int pieceCount() {
        return pieceGroup.size();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        List<Piece> pieceList = pieceGroup.getPieceList();

        int pieceCount = 0;
        while(pieceCount < BOARD_SIZE * BOARD_SIZE) {
            sb.append(pieceList.get(pieceCount).getRepresentation());

            if (pieceCount % BOARD_SIZE == BOARD_SIZE - 1) {
                sb.append(NEW_LINE);
            }

            pieceCount++;
        }

        return sb.toString();
    }

    public int getPieceCount(Color color, Type type) {
        return pieceGroup.getPieceCount(color, type);
    }

    public Piece findPiece(String position) {
        int yPos = getYPos(position);
        int xPos = getXPos(position);
        return pieceGroup.findPiece(yPos, xPos);
    }

    public void initializeEmpty() {
        pieceGroup.initializeEmpty();
    }

    public void move(String position, Piece piece) {
        int yPos = getYPos(position);
        int xPos = getXPos(position);
        pieceGroup.move(yPos, xPos, piece);
    }

    private int getXPos(String position) {
        return position.charAt(0) - 'a';
    }

    private int getYPos(String position) {
        return BOARD_SIZE
                - Character.getNumericValue(position.charAt(1));
    }
}
