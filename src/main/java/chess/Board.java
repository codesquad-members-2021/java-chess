package chess;

import pieces.Color;
import pieces.Pawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.StringUtils.*;

public class Board {

    private final Map<Color, List<Pawn>> pawnList;
    private final int FILES = 8;

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
        for (int i = 0; i < FILES; i++) {
            add(new Pawn(Color.WHITE));
            add(new Pawn(Color.BLACK));
        }
    }

    public String getPawnsResult(Color color) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pawn pawn : pawnList.get(color)) {
            stringBuilder.append(pawn.getRepresentation());
        }
        return stringBuilder.toString();
    }

    public String print() {
        StringBuilder output = new StringBuilder();
        output.append(appendNewLine("........"));
        output.append(appendNewLine(getPawnsResult(Color.BLACK)));
        output.append(appendNewLine("........"));
        output.append(appendNewLine("........"));
        output.append(appendNewLine("........"));
        output.append(appendNewLine("........"));
        output.append(appendNewLine(getPawnsResult(Color.WHITE)));
        output.append("........");
        return output.toString();
    }

    public int pieceCount() {
        return 0;
    }

    public String showBoard() {
        return "";
    }
}
