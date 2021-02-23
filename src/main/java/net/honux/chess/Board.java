package net.honux.chess;

import net.honux.chess.pieces.Piece;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Piece> whitePawns = new ArrayList<Piece>();
    private List<Piece> blackPawns = new ArrayList<Piece>();


    public void addWhitePawns(Piece piece) {
        if (!piece.getColor().equals(Piece.WHITE_COLOR)) {
            throw new InvalidParameterException("The color of this pawn must be white.");
        }
        whitePawns.add(piece);
    }

    public void addBlackPawns(Piece piece) {
        if (!piece.getColor().equals(Piece.BLACK_COLOR)) {
            throw new InvalidParameterException("The color of this pawn must be black.");
        }
        blackPawns.add(piece);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Piece findWhitePawn(int index) {
        if (whitePawns.size() < index + 1) {
            throw new InvalidParameterException("The index must be equal to or less than the size of the whitePawns.");
        }
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        if (blackPawns.size() < index + 1) {
            throw new InvalidParameterException("The index must be equal to or less than the size of the whitePawns.");
        }
        return blackPawns.get(index);
    }

    public void initialize() {
        int boardSize = 8;

        for (int i = 0; i < boardSize; i++) {
            addWhitePawns(new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION));
            addBlackPawns(new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION));
        }

    }

    public String getWhitePawnsResult() {
        StringBuilder whiteResult = new StringBuilder();

        for (Piece whitePiece : whitePawns) {
            whiteResult.append(whitePiece.getRepresentation());
        }
        return whiteResult.toString();

    }

    public String getBlackPawnsResult() {
        StringBuilder blackResult = new StringBuilder();

        for (Piece blackPiece : blackPawns) {
            blackResult.append(blackPiece.getRepresentation());
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
