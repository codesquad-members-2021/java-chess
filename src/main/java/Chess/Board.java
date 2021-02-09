package Chess;

import java.util.ArrayList;

public class Board {
    private int size;
    private ArrayList<Pawn> pieces = new ArrayList<Pawn>(32);

    public void add(Pawn p){
        pieces.add(p);
    }

    public int size(){
        return pieces.size();
    }

    public Pawn findPawn(int i){
        return pieces.get(i);
    }
}
