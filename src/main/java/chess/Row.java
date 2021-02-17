package chess;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Character> pices = new ArrayList<>(Board.BOARDSIZE);

    public Character getPices(int index) {
        return pices.get(index);
    }

    public void addPices(char representation) {
        pices.add(representation);
    }

    public int getPicesSize() {
        return pices.size();
    }

    public Row initWhitePawns(Board board) {
        Row row = new Row();
        for (int i = 0; i < Board.BOARDSIZE; i++) {
            row.addPices(board.getWhitePawn(i).getRepresentation());
        }
        return row;
    }

    public Row initBlackPawns(Board board) {
        Row row = new Row();
        for (int i = 0; i < Board.BOARDSIZE; i++) {
            row.addPices(board.getBlackPawn(i).getRepresentation());
        }
        return row;
    }


    public Row initBlank() {
        Row row = new Row();
        for (int i = 0; i < Board.BOARDSIZE; i++) {
            row.addPices('.');
        }
        return row;
    }


}
