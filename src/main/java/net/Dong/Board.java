package net.Dong;

import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> arrPawn;
    int numberOfMal;

    public void add(Pawn ins) {
        //arrPawn.add()
        
    }

    public void removePawn(Pawn rem) {
        //arrlist에서 삭제하는 코드 작성
    }

    public int size() {
        // return number of Mal
        return numberOfMal;
    }

    public Pawn.Color findPawn(int index) {
        return arrPawn.get(index).getColor();
    }

}
