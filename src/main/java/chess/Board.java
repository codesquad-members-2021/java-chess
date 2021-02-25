package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static int BOARD_SIZE = 8;
    private List<Piece> whitePawns = new ArrayList<>(BOARD_SIZE);
    private List<Piece> whiteOthers = new ArrayList<>(BOARD_SIZE);
    private List<Piece> blackPawns = new ArrayList<>(BOARD_SIZE);
    private List<Piece> blackOthers = new ArrayList<>(BOARD_SIZE);

    public void addWhitePawn(Piece piece) {
        if (piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.WHITE)) {
            whitePawns.add(piece);
        }
    }

    public void addBlackPawn(Piece piece) {
        if (piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.BLACK)) {
            blackPawns.add(piece);
        }
    }

    public void addWhiteOther(Piece piece) {
        if (!piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.WHITE)) {
            whiteOthers.add(piece);
        }
    }

    public void addBlackOther(Piece piece) {
        if (!piece.getName().equals(Piece.PAWN) && piece.getColor().equals(Piece.BLACK)) {
            blackOthers.add(piece);
        }
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        addWhiteOther(Piece.createWhiteRook()); // whites
        addWhiteOther(Piece.createWhiteKnight());
        addWhiteOther(Piece.createWhiteBishop());
        addWhiteOther(Piece.createWhiteQueen());
        addWhiteOther(Piece.createWhiteKing());
        addWhiteOther(Piece.createWhiteBishop());
        addWhiteOther(Piece.createWhiteKnight());
        addWhiteOther(Piece.createWhiteRook());
        addBlackOther(Piece.createBlackRook()); // blacks
        addBlackOther(Piece.createBlackKnight());
        addBlackOther(Piece.createBlackBishop());
        addBlackOther(Piece.createBlackQueen());
        addBlackOther(Piece.createBlackKing());
        addBlackOther(Piece.createBlackBishop());
        addBlackOther(Piece.createBlackKnight());
        addBlackOther(Piece.createBlackRook());
    }

    public String makeBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlackOthersResult()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getWhiteOthersResult()));
        return sb.toString();
    }

    public int pieceCount() {
        return whitePawns.size() + blackPawns.size() + whiteOthers.size() + blackOthers.size();
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

    public String getWhiteOthersResult() {
        return getPawnsResult(whiteOthers);
    }

    public String getBlackOthersResult() {
        return getPawnsResult(blackOthers);
    }

    private String getPawnsResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece aPiece : pieces) {
            sb.append(aPiece.getSymbol());
        }
        return sb.toString();
    }

    private String getBlankLine() {
        return "........";
    }
}
