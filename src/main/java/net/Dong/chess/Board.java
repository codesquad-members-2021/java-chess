package net.Dong.chess;

import net.Dong.chess.Pawn;
import static net.Dong.chess.Pawn.Color;
//import static net.Dong.chess.Pawn;

import java.util.ArrayList;

public class Board {

    ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
    ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();


    public int whiteAdd(Pawn pawn) {
        //arrPawn.add()
        whitePawns.add(pawn);
        return whitePawns.size();
    }
    public int blackAdd(Pawn pawn) {
        //arrPawn.add()
        blackPawns.add(pawn);
        return blackPawns.size();
    }

    public void removePawn(Pawn remove) {
        //arrlist에서 삭제하는 코드 작성
    }

    public int size() {
        return whitePawns.size()+blackPawns.size();
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
        // white pawn 8, black pawn 8
        for(int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION));
        }

        for(int i = 0; i < 8; i++) {
            addBlackPawn(new Pawn(Color.BALCK, Pawn.BLACK_REPRESENTATION));
        }
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
            whitePawns.add(new Pawn(Color.WHITE));
        }
    }

    private void addPawnBlack(int numOfPawn) {
        for(int i=0 ; i<numOfPawn ; i++) {
            whitePawns.add(new Pawn(Color.WHITE));
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

    private String getPawnsResult(ArrayList<Pawn> whatPawns) {
        StringBuilder sb = new StringBuilder();

        for(Pawn p : whatPawns) {
            sb.append(p.getSymbol());
        }
        return sb.toString();
    }



}
