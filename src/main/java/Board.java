import java.util.ArrayList;

public class Board {
    private static final int PAWNSNUM = 8;
    private ArrayList<Pawn> whitePawns;
    private ArrayList<Pawn> blackPawns;

    public Board(){
        for(int i = 0; i < PAWNSNUM; i++){
            whitePawns.add(new Pawn("white"));
            blackPawns.add(new Pawn("black"));
        }
    }

}
