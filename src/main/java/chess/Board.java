package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Pawn> whitePawn = new ArrayList<>();
    List<Pawn> blackPawn = new ArrayList<>();

    char[][] board = new char[8][8];

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
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
        }

        for (int i = 0; i < 8; i++) {
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    void initBoard(){
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                if(i == 1){
                    board[i][j]= getWhitePawn(i).getRepresentation();
                    continue;
                }
                if(i == 6){
                    board[i][j]= getBlackPawn(i).getRepresentation();
                    continue;
                }
                board[i][j] = '.';
            }
        }
    }

    void print(){
        initialize();
        initBoard();

        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                System.out.printf("%3c",board[i][j]);
            }
            System.out.println();
        }
    }
}
