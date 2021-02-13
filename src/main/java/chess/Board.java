package chess;

import pieces.Color;
import pieces.Pawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final Map<Color, List<Pawn>> pawnList;

    public Board() {
        this.pawnList = new HashMap<>();
        this.pawnList.put(Color.BLACK, new ArrayList<>());
        this.pawnList.put(Color.WHITE, new ArrayList<>());
    }

    public Pawn findPawn(Color color, int index) {
        return pawnList.get(color).get(index);
    }

    public void add(Pawn pieces) {
        pawnList.get(pieces.getColor()).add(pieces);
    }

    public int size() {
        return pawnList.get(Color.BLACK).size() + pawnList.get(Color.WHITE).size();
    }

    public void initialize() {
    }

    public String getWhitePawnsResult() {
        return null;
    }

    public String getBlackPawnsResult() {
        return null;
    }
}
