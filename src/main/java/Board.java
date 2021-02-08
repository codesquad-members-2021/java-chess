import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn){
        this.pawns.add(pawn);
    }

    public int size(){
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }
}
