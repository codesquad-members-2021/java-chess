package net.eno.chess;

import net.eno.pieces.Pawn;
import net.eno.pieces.Piece;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

public class Board {

    private final Map<String, List<Pawn>> pawns;

    public Board() {
        this.pawns = new HashMap<>();
        this.pawns.put(Piece.WHITE.getColor(), new LinkedList<>());
        this.pawns.put(Piece.BLACK.getColor(), new LinkedList<>());
    }

    public void addPawn(Piece piece, Pawn pawn) {
        this.pawns.get(piece.getColor()).add(pawn);
    }

    public int pawnSize(Piece piece) {
        return this.pawns.get(piece.getColor()).size();
    }

    public Pawn findPawn(Piece piece, int index) {
        return this.pawns.get(piece.getColor()).get(index);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addPawn(Piece.WHITE, new Pawn(Piece.WHITE));
            addPawn(Piece.BLACK, new Pawn(Piece.BLACK));
        }
    }

    public String getPawnsResult(Piece piece) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pawnSize(piece); i++) {
            result.append(findPawn(piece, i).getRepresentation());
        }
        return result.toString();
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        result.append("........");
        result.append("\n");
        result.append(getPawnsResult(Piece.BLACK));
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append(getPawnsResult(Piece.WHITE));
        result.append("\n");
        result.append("........");
        System.out.println(result);
    }

}
