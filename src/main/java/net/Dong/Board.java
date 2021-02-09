package net.Dong;

import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> arrPawn = new ArrayList<>();


    public int add(Pawn ins) {
        //arrPawn.add()
        arrPawn.add(ins);
        return arrPawn.size();
    }

    public void removePawn(Pawn rem) {
        //arrlist에서 삭제하는 코드 작성
    }

    public int size() {
        // return number of Mal
        return arrPawn.size();
    }

    public Pawn.Color findPawn(int index) {
        return arrPawn.get(index).getColor();
    }

}
