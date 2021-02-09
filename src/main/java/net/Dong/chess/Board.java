package net.Dong.chess;

import net.Dong.chess.Pawn;

import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> arrPawn = new ArrayList<>();


    public int add(Pawn pawn) {
        //arrPawn.add()
        arrPawn.add(pawn);
        return arrPawn.size();
    }

    public void removePawn(Pawn remove) {
        //arrlist에서 삭제하는 코드 작성
    }

    public int size() {
        // return number of Mal
        return arrPawn.size();
    }

    public Pawn.Color findPawn(int index) {
        // Receives an index and returns it as an object color
        return arrPawn.get(index).getColor();
    }

}
