package net.Dong.chess;

import net.Dong.chess.Pawn;
import static net.Dong.chess.Pawn.Color;
//import static net.Dong.chess.Pawn;

import java.util.ArrayList;

public class Board {
    ArrayList<Pawn> whitePawn = new ArrayList<>();
    ArrayList<Pawn> blackPawn = new ArrayList<>();


    public int whiteAdd(Pawn pawn) {
        //arrPawn.add()
        whitePawn.add(pawn);
        return whitePawn.size();
    }
    public int blackAdd(Pawn pawn) {
        //arrPawn.add()
        blackPawn.add(pawn);
        return blackPawn.size();
    }

    public void removePawn(Pawn remove) {
        //arrlist에서 삭제하는 코드 작성
    }

    public int size() {
        // return number of Mal
        return whitePawn.size()+blackPawn.size();
    }

    private int whitePawnSize() {
        return whitePawn.size();
    }

    public int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn.Color findPawn(int index) {
        // Receives an index and returns it as an object color
        return whitePawn.get(index).getColor();
    }

    public Pawn.Color findblackPawn(int index) {
        // Receives an index and returns it as an object color
        return whitePawn.get(index).getColor();
    }

    public void initialize() {




        // white pawn 8, black pawn 8
        addPawn(Color.BALCK , 8);
        addPawn(Color.WHITE , 8);
    }

    private void addPawn(Pawn.Color color, int numOfPawn) {
        if(color == Color.BALCK) {
            addPawnBlack(numOfPawn);
            return;
        }

        if (color == Color.WHITE) {
            addPawnBlack(numOfPawn);
        }
    }

    private void addPawnWhite(int numOfPawn) {
        for(int i=0 ; i<numOfPawn ; i++) {
            whitePawn.add(new Pawn(Color.WHITE));
        }
    }

    private void addPawnBlack(int numOfPawn) {
        for(int i=0 ; i<numOfPawn ; i++) {
            whitePawn.add(new Pawn(Color.WHITE));
        }
    }



    private String print() {
        //print current state of chess board
        // 화면에 출력할 결과를 StringBuilder에 저장한 후 String으로 반환하는 메소드를 구현한다
        StringBuilder sb = new StringBuilder();

        return "";
    }


    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawn);
    }


    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawn);
    }

    private String getPawnsResult(ArrayList<Pawn> whatPawn) {
        StringBuilder sb = new StringBuilder();
        int len = whatPawn.size();
        for(Pawn p : whatPawn) {
            sb.append(p.getSymbol());
        }
        return sb.toString();
    }



}
