package net.Dong.chess;

import static net.Dong.chess.Pawn.Color;

import java.util.List;
import java.util.ArrayList;

public class Board {

    private List<Pawn> whitePawn = new ArrayList<>();
    private List<Pawn> blackPawn = new ArrayList<>();


    public void addWhite(Pawn pawn) {
        whitePawn.add(pawn);
    }

    public void addBlack(Pawn pawn) {
        blackPawn.add(pawn);


    }


    public int size() {

        return whitePawn.size() + blackPawn.size();

    }

    private int whitePawnSize() {
        return whitePawns.size();
    }

    public int blackPawnSize() {
        return blackPawns.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }


    void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }


    public void initialize() {

        addPawnWhite(Pawn.InitialNumOfPawn);
        addPawnBlack(Pawn.InitialNumOfPawn);
    }

    private void addPawnWhite(int numOfPawn) {
        for (int i = 0; i < numOfPawn; i++) {
            whitePawn.add(new Pawn(Color.WHITE));

        }
    }

    private void addPawnBlack(int numOfPawn) {
        for (int i = 0; i < numOfPawn; i++) {
            whitePawn.add(new Pawn(Color.BLACK));
        }
    }


    private String getBlankLine() {
        return "........";
    }

    public String print() {
        //print current state of chess board
        // 화면에 출력할 결과를 StringBuilder에 저장한 후 String으로 반환하는 메소드를 구현한다
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlackPawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getBlankLine());
        sb.append('\n');
        sb.append(getWhitePawnsResult());
        sb.append('\n');
        sb.append(getBlankLine());
        System.out.println(sb.toString());
        return "";
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }


    private String getPawnsResult(List<Pawn> whatPawn) {
        StringBuilder sb = new StringBuilder();
        int len = whatPawn.size();
        for (Pawn pawn : whatPawn) {
            sb.append(pawn.getSymbol());

        }
        return sb.toString();
    }


}
