package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static int MAX_NUM = 8;
    private List<Piece> whitePawns = new ArrayList<>(MAX_NUM);
    private List<Piece> whiteButNotPawns = new ArrayList<>(MAX_NUM);
    private List<Piece> blackPawns = new ArrayList<>(MAX_NUM);
    private List<Piece> blackButNotPawns = new ArrayList<>(MAX_NUM);

    boolean addWhitePawn(Piece piece) {
        if (piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.WHITE)) {
            whitePawns.add(piece);
            return true;
        }
        return false;
    }

    boolean addBlackPawn(Piece piece) {
        if (piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.BLACK)) {
            blackPawns.add(piece);
            return true;
        }
        return false;
    }
    boolean addWhiteButNotPawn(Piece piece) {
        if (!piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.WHITE)) {
            whiteButNotPawns.add(piece);
            return true;
        }
        return false;
    }

    boolean addBlackButNotPawn(Piece piece) {
        if (!piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.BLACK)) {
            blackButNotPawns.add(piece);
            return true;
        }
        return false;
    }

    public int getWhitePawnsSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece aPiece : pieces) {
            sb.append(aPiece.getRepresentation());
        }
        return sb.toString();
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    void initialize() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();
        Piece whiteRook = Piece.createWhiteRook();
        Piece blackRook = Piece.createBlackRook();
        Piece whiteKnight = Piece.createWhiteKnight();
        Piece blackKnight = Piece.createBlackKnight();
        Piece whiteBishop = Piece.createWhiteBishop();
        Piece blackBishop = Piece.createBlackBishop();
        Piece whiteQueen = Piece.createWhiteQueen();
        Piece blackQueen = Piece.createBlackQueen();
        Piece whiteKing = Piece.createWhiteKing();
        Piece blackKing = Piece.createBlackKing();
        for (int i = 0; i < MAX_NUM; i++) {
            addWhitePawn(whitePawn);
            addBlackPawn(blackPawn);
        }
        addWhiteButNotPawn(whiteRook); // whites
        addWhiteButNotPawn(whiteKnight);
        addWhiteButNotPawn(whiteBishop);
        addWhiteButNotPawn(whiteQueen);
        addWhiteButNotPawn(whiteKing);
        addWhiteButNotPawn(whiteBishop);
        addWhiteButNotPawn(whiteKnight);
        addWhiteButNotPawn(whiteRook);
        addBlackButNotPawn(blackRook); // blacks
        addBlackButNotPawn(blackKnight);
        addBlackButNotPawn(blackBishop);
        addBlackButNotPawn(blackQueen);
        addBlackButNotPawn(blackKing);
        addBlackButNotPawn(blackBishop);
        addBlackButNotPawn(blackKnight);
        addBlackButNotPawn(blackRook);
    }

    void showBoard() {
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

    public int pieceCount() {
        return whitePawns.size() + blackPawns.size()
                + whiteButNotPawns.size() + blackButNotPawns.size();
    }
}
