import java.util.ArrayList;

public class Board {
    private int size;
    private ArrayList<Pawn> pieces = new ArrayList<Pawn>(32);

    void add(Pawn p){
        pieces.add(p);
    }

    int size(){
        return pieces.size();
    }

    Pawn findPawn(int i){
        return pieces.get(i);
    }
}
