package net.honux.chess;

import net.honux.chess.pieces.Pawn;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> whitePawns = new ArrayList<Pawn>();
    private List<Pawn> blackPawns = new ArrayList<Pawn>();


    public void addWhitePawns(Pawn pawn) {
        if (!pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            throw new InvalidParameterException("The color of this pawn must be white.");
        }whitePawns.add(pawn);
    }

    public void addBlackPawns(Pawn pawn) {
        if (!pawn.getColor().equals(Pawn.BLACK_COLOR)){
            throw new InvalidParameterException("The color of this pawn must be black.");
        }
        blackPawns.add(pawn);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findWhitePawn(int index) {
        if (whitePawns.size() < index + 1) {
            throw new InvalidParameterException("The index must be equal to or less than the size of the whitePawns.");
        }
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        if (blackPawns.size() < index + 1) {
            throw new InvalidParameterException("The index must be equal to or less than the size of the whitePawns.");
        }
        return blackPawns.get(index);
    }

    public void initialize() {
        int boardSize = 8;

        for (int i = 0; i < boardSize; i++) {
            addWhitePawns(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addBlackPawns(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }

    }

    public String getWhitePawnsResult() {
        StringBuilder whiteResult = new StringBuilder();

        for (Pawn whitePawn : whitePawns) {
            whiteResult.append(whitePawn.getRepresentation());
        }
        return whiteResult.toString();

    }

    public String getBlackPawnsResult() {
        StringBuilder blackResult = new StringBuilder();

        for (Pawn blackPawn : blackPawns) {
            blackResult.append(blackPawn.getRepresentation());
        }
        return blackResult.toString();
    }

    private String emptyLine() {
        String emptyLine = "........";
        return emptyLine;
    }

    public String boardPrint() {
        StringBuilder printResult = new StringBuilder();
        String lineBreak = System.getProperty("line.separator");
        printResult.append(emptyLine()).append(lineBreak);
        printResult.append(getBlackPawnsResult()).append(lineBreak);
        printResult.append(emptyLine()).append(lineBreak);
        printResult.append(emptyLine()).append(lineBreak);
        printResult.append(emptyLine()).append(lineBreak);
        printResult.append(emptyLine()).append(lineBreak);
        printResult.append(getWhitePawnsResult()).append(lineBreak);
        printResult.append(emptyLine());
        return printResult.toString();
    }


}
