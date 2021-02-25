package net.tree.chess;

import net.tree.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Pawn> pawnList = new ArrayList<>();
    private final int BOARD_SIZE = 8;
    private String line = "........\n";

    public void addPawnToPawnList(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int checkPawnSize() {
        return pawnList.size();
    }

    public Pawn findPawn(int listIndex) {

        Pawn pawn = pawnList.get(listIndex);
        return pawn;
    }

    public void initialize() {
        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            addPawnToPawnList(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addPawnToPawnList(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
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

    public String getPawnsRepresentation() {
        StringBuilder pawnsRepresentation = new StringBuilder();
        pawnsRepresentation.append(line);
        pawnsRepresentation.append(getPawnsResult(Pawn.BLACK_REPRESENTATION) + "\n");
        pawnsRepresentation.append(line);
        pawnsRepresentation.append(line);
        pawnsRepresentation.append(line);
        pawnsRepresentation.append(line);
        pawnsRepresentation.append(getPawnsResult(Pawn.WHITE_REPRESENTATION) + "\n");
        pawnsRepresentation.append(line);

        return pawnsRepresentation.toString();
    }


}
