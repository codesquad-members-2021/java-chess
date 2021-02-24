package cooper.chess;

import cooper.chess.piece.*;
import java.util.*;

import static cooper.chess.utils.StringUtils.*;

public class Board {
    public static final int BOARD_SIZE = 8;

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
        while (pieceCount < BOARD_SIZE * BOARD_SIZE) {
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

    public Piece findPiece(Position position) {
        return pieceGroup.findPiece(position);
    }

    public void initializeEmpty() {
        pieceGroup.initializeEmpty();
    }

    public void addPiece(Position position, Piece piece) {
        pieceGroup.addPiece(position, piece);
    }

    public void move(Position before, Position after) {
        pieceGroup.move(before, after);
    }

    public double calculatePoint(Color color) {
        return pieceGroup.calculatePoint(color);
    }

    public List<Piece> sortByTypePoint(Color color) {
        List<Piece> list = pieceGroup.getListBy(color);
        list.sort(Comparator.comparingDouble(piece -> piece.getType().getDefaultPoint()));
        return list;
    }

    public List<Piece> sortByTypePointReverse(Color color) {
        List<Piece> list = pieceGroup.getListBy(color);
        list.sort(Comparator.comparingDouble(piece -> - piece.getType().getDefaultPoint()));
        return list;
    }
}
