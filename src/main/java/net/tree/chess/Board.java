package net.tree.chess;

import net.tree.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Pawn> pawnList = new ArrayList<>();
    final int BOARD_SIZE = 8;
    String blankDot = "........\n";


    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int checkPawnSize() {
        return pawnList.size();
    }

    public Pawn findPawn(int listIndex) {

        Pawn pawn = pawnList.get(listIndex);
        return pawn;
    }

    public List<Pawn> initialize() {
        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
        return pawnList;
    }

    public String getPawnsResult(char representation) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < pawnList.size() ; i++) {
            if(pawnList.get(i).getRepresentation() == representation) {
                sb.append(representation);
            }
        }
        return sb.toString();
    }

    public String saveStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(blankDot);
        sb.append(getPawnsResult(Pawn.BLACK_REPRESENTATION) + "\n");
        sb.append(blankDot);
        sb.append(blankDot);
        sb.append(blankDot);
        sb.append(blankDot);
        sb.append(getPawnsResult(Pawn.WHITE_REPRESENTATION) + "\n");
        sb.append(blankDot);

        return sb.toString();
    }

    public void print() {
        System.out.println(saveStringBuilder());
    }

}
