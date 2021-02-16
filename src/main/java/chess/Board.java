package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> whitePawn = new ArrayList<>();
    List<Pawn> blackPawn = new ArrayList<>();

    private final String BLANK = "........";

    List<String []> board = new ArrayList<>();

    public void addWhitePawn(Pawn pawn) {
        whitePawn.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawn.add(pawn);
    }

    public int whitePawnSize() {
        return whitePawn.size();
    }

    public int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn getWhitePawn(int index) {
        return whitePawn.get(index);
    }

    public Pawn getBlackPawn(int index) {
        return blackPawn.get(index);
    }

    String getWhitePawnsResult(){
        return getPawnsResult(Color.WHITE);
    }

    String getBlackPawnsResult(){
        return  getPawnsResult(Color.BLACK);
    }

    String getPawnsResult(Color color){
        StringBuilder sb = new StringBuilder();
        switch (color.getColorName()){
            case "white":
                for(Pawn pawn : whitePawn){
                    sb.append(pawn.getRepresentation());
                }
                return sb.toString();

            case "black":
                for(Pawn pawn : blackPawn){
                    sb.append(pawn.getRepresentation());
                }
                return sb.toString();
        }
        return sb.toString();
    }

    void initialize() {
        initPawn();

        for(int i =0; i < 8; i++){

            switch (i){
                case 1:
                    board.add(getWhitePawnsResult().split(""));
                    continue;
                case 6:
                    board.add(getBlackPawnsResult().split(""));
                    continue;

                default:
                    board.add(BLANK.split(""));
            }
        }
    }

    void initPawn(){
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    String print(){
        initialize();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< board.size(); i++){
            for(int j =0; j< board.size(); j++){
                sb.append(board.get(i)[j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
