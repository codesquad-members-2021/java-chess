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

    public void add(Piece piece) {
        pieceGroup.add(piece);
    }

    public int pieceCount() {
        return pieceGroup.size();
    }

    public Piece findPawn(int index, Color color) {
        return pieceGroup.findPawn(index, color);
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        final String BLANK = "........";

        sb.append(appendNewLine(getPawnsResult(Color.WHITE)));
        sb.append(appendNewLine(BLANK));
        sb.append(appendNewLine(BLANK));
        sb.append(appendNewLine(BLANK));
        sb.append(appendNewLine(BLANK));
        sb.append(appendNewLine(getPawnsResult(Color.BLACK)));

        return sb.toString();
    }

    private String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        List<Piece> pieceList = pieceGroup.getPawnList(color);

        for (int col = 0; col < BOARD_SIZE; col++) {
            sb.append(pieceList.get(col).getRepresentation());
        }

        sb.append(NEW_LINE);

        for (int col = BOARD_SIZE; col < PieceGroup.PIECE_LIST_MAX; col++) {
            sb.append(pieceList.get(col).getRepresentation());
        }

        return sb.toString();
    }
}
