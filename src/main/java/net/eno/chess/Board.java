package net.eno.chess;

import net.eno.pieces.Pawn;
import net.eno.pieces.Color;
import net.eno.pieces.Representation;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Board {

    private final Map<String, List<Pawn>> pawns;

    public Board() {
        this.pawns = new HashMap<>();
        this.pawns.put(Color.WHITE.toString(), new ArrayList<>());
        this.pawns.put(Color.BLACK.toString(), new ArrayList<>());
    }

    public void addPawn(Color color, Pawn pawn) {
        this.pawns.get(color.toString()).add(pawn);
    }

    public int pawnSize(Color color) {
        return this.pawns.get(color.toString()).size();
    }

    public Pawn findPawn(Color color, int index) {
        return this.pawns.get(color.toString()).get(index);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addPawn(Color.WHITE, new Pawn(Color.WHITE, Representation.WHITE));
            addPawn(Color.BLACK, new Pawn(Color.BLACK, Representation.BLACK));
        }
    }

    public String getPawnsResult(Color color) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pawnSize(color); i++) {
            result.append(findPawn(color, i).getRepresentation());
        }
        return result.toString();
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        result.append("........");
        result.append("\n");
        result.append(getPawnsResult(Color.BLACK));
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append(getPawnsResult(Color.WHITE));
        result.append("\n");
        result.append("........");
        System.out.println(result);
    }

}
