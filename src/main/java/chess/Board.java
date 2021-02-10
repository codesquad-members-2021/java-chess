package chess;

import pieces.Pawn;
import pieces.Piece;

import java.util.HashMap;
import java.util.LinkedList;

public class Board {

    private final HashMap<String, LinkedList<Pawn>> pawns;

    public Board() {
        this.pawns = new HashMap<>();
        this.pawns.put(Piece.PAWN_WHITE.color, new LinkedList<>());
        this.pawns.put(Piece.PAWN_BLACK.color, new LinkedList<>());
    }

    public void addPawn(String color, Pawn pawn) {
        this.pawns.get(color).add(pawn);
    }

    public int pawnSize(String color) {
        return this.pawns.get(color).size();
    }

    public Pawn findPawn(String color, int index) {
        return this.pawns.get(color).get(index);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addPawn(Piece.PAWN_WHITE.color, new Pawn(Piece.PAWN_WHITE.color, Piece.PAWN_WHITE.representation));
            addPawn(Piece.PAWN_BLACK.color, new Pawn(Piece.PAWN_BLACK.color, Piece.PAWN_BLACK.representation));
        }
    }

    public String getPawnsResult(String color) {
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
        result.append(getPawnsResult(Piece.PAWN_BLACK.color));
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append("........");
        result.append("\n");
        result.append(getPawnsResult(Piece.PAWN_WHITE.color));
        result.append("\n");
        result.append("........");
        System.out.println(result);
    }

}
