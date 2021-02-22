package chess;

import pieces.Piece;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private static final int BOARD_FILE = 8;

    public int size() {
        return whitePieces.size() + blackPieces.size();
    }

    public Piece findWhitePawn(int index) {
        return whitePieces.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPieces.get(index);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePieces);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPieces);
    }

    private String getPawnsResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (char representation : getRepresentations(pieces)) {
            sb.append(representation);
        }
        return sb.toString();
    }

    private char[] getRepresentations(List<Piece> pieces) {
        char[] representations = new char[pieces.size()];
        for (int i = 0; i < pieces.size(); i++) {
            representations[i] = pieces.get(i).getRepresentation();
        }
        return representations;
    }

    public void addWhitePawn(Piece piece) {
        if (piece.getColor() != Piece.Color.WHITE) {
            throw new InvalidParameterException("pawn의 색을 확인해 주세요");
        }
        whitePieces.add(piece);
    }

    public void addBlackPawn(Piece piece) {
        if (piece.getColor() != Piece.Color.BLACK) {
            throw new InvalidParameterException("pawn의 색을 확인해 주세요");
        }
        blackPieces.add(piece);
    }

    public void initialize() {
        for (int i = 0; i < BOARD_FILE; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        String emptyRank = "........";
        result.append(appendNewLine(emptyRank))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(emptyRank))
                .append(appendNewLine(emptyRank))
                .append(appendNewLine(emptyRank))
                .append(appendNewLine(emptyRank))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(emptyRank);
        return result.toString();
    }
}
