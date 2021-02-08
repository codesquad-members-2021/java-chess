import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<>();

    public List<Pawn> pawns() {
        return Collections.unmodifiableList(pawns);
    }

    public boolean add(Pawn pawn) {
        return pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }
}
