package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Piece> whitePieceList = new ArrayList<>();
    private final List<Piece> blackPieceList = new ArrayList<>();

    public void addWhitePawn(Piece piece) {
        if (piece.getColor() == Piece.WHITE) {
            whitePieceList.add(piece);
        }
    }

    public void addBlackPawn(Piece piece) {
        if (piece.getColor() == Piece.BLACK) {
            blackPieceList.add(piece);
        }
    }

    public int whiteSize() {
        return whitePieceList.size();
    }

    public int blackSize() {
        return blackPieceList.size();
    }

    public Piece findWhitePawn(int idx) {
        return whitePieceList.get(idx);
    }

    public Piece findBlackPawn(int idx) {
        return blackPieceList.get(idx);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Piece(Piece.WHITE, Piece.WHITE_REPRESENTATION));
            addBlackPawn(new Piece(Piece.BLACK, Piece.BLACK_REPRESENTATION));
        }
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePieceList);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPieceList);
    }

    private String getPawnsResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public void print() {
        StringBuilder boardOutput = new StringBuilder();
        boardOutput.append("........\n");
        boardOutput.append(getBlackPawnsResult() + "\n");
        boardOutput.append("........\n");
        boardOutput.append("........\n");
        boardOutput.append("........\n");
        boardOutput.append("........\n");
        boardOutput.append(getWhitePawnsResult() + "\n");
        boardOutput.append("........\n");
        System.out.println(boardOutput.toString());
    }

}
