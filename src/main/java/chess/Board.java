package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> whitePawn = new ArrayList<>();
    List<Pawn> blackPawn = new ArrayList<>();

    char[][] board = new char[8][8];

    public void addWhitePawn(Pawn pawn) {
        whitePawn.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawn.add(pawn);
    }

    public int whitePawnSize() {
        return whitePawn.size();
    }

    public int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn getWhitePawn(int index) {
        return whitePawn.get(index);
    }

    public Pawn getBlackPawn(int index) {
        return blackPawn.get(index);
    }

    String getPawnsResult(Color color){
        StringBuilder sb = new StringBuilder();
        switch (color.getColorName()){
            case "white":
                for(Pawn pawn : whitePawn){
                    sb.append(pawn.getRepresentation());
                }
                return sb.toString();

            case "black":
                for(Pawn pawn : blackPawn){
                    sb.append(pawn.getRepresentation());
                }
                return sb.toString();
        }
        return sb.toString();
    }

    void initialize() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
        }

        for (int i = 0; i < 8; i++) {
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }
}
