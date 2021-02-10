package Chess;

import java.util.ArrayList;

public class Board {
    private int size;
    private ArrayList<Pawn> pawnList = new ArrayList<Pawn>();

    public void add(Pawn p){
        pawnList.add(p);
    }

    public int size(){
        return pawnList.size();
    }

    public Pawn findPawn(int i){
        return pawnList.get(i);
    }
}
