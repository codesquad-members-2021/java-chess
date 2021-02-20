package net.Dong.chess;
import static net.Dong.chess.Pawn.Color;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private List<Pawn> whitePawn = new ArrayList<>();
    private List<Pawn> blackPawn = new ArrayList<>();


    public void whiteAdd(Pawn pawn) {
        whitePawn.add(pawn);
    }
    public void blackAdd(Pawn pawn) {
        blackPawn.add(pawn)
    }

    public void removePawn(Pawn remove) {
    }

    public int size() {
        return whitePawn.size()+blackPawn.size();
    }

    private int whitePawnSize() {
        return whitePawn.size();
    }

    public int blackPawnSize() {
        return blackPawn.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawn.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return whitePawn.get(index);
    }

    public void initialize() {
        addPawnWhite(8);
        addPawnBlack(8);
    }

    private void addPawnWhite(int numOfPawn) {
        for(int i=0 ; i<numOfPawn ; i++) {
            whitePawn.add(new Pawn(Color.WHITE));
        }
    }

    private void addPawnBlack(int numOfPawn) {
        for(int i=0 ; i<numOfPawn ; i++) {
            whitePawn.add(new Pawn(Color.BALCK));
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

    private String getPawnsResult(List<Pawn> whatPawn) {
        StringBuilder sb = new StringBuilder();
        int len = whatPawn.size();
        for(Pawn p : whatPawn) {
            sb.append(p.getSymbol());
        }
        return sb.toString();
    }



}
