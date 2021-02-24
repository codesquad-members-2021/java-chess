package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static int PAWN_NUM = 8;
    private List<Piece> whitePieces = new ArrayList<>(PAWN_NUM);
    private List<Piece> blackPieces = new ArrayList<>(PAWN_NUM);

    boolean addWhitePawn(Piece piece) {
        if (piece.getColor().equals(Piece.WHITE)) {
            whitePieces.add(piece);
            return true;
        }
        return false;
    }

    boolean addBlackPawn(Piece piece) {
        if (piece.getColor().equals(Piece.BLACK)) {
            blackPieces.add(piece);
            return true;
        }
        return false;
    }

    public int getWhitePawnsSize() {
        return whitePieces.size();
    }

    public int getBlackPawnsSize() {
        return blackPieces.size();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePieces);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPieces);
    }

    private String getPawnsResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece aPiece : pieces) {
            sb.append(aPiece.getRepresentation());
        }
        return sb.toString();
    }

    public Piece findWhitePawn(int index) {
        return whitePieces.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPieces.get(index);
    }

    void initialize() {
        Piece whitePiece = new Piece();
        Piece blackPiece = new Piece(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
        for (int i = 0; i < PAWN_NUM; i++) {
            addWhitePawn(whitePiece);
            addBlackPawn(blackPiece);
        }
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        System.out.println(sb.toString());
    }

    private String getBlankLine() {
        return "........";
    }
}
