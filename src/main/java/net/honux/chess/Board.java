package net.honux.chess;

import net.honux.chess.pieces.Piece;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import static utils.StringUtils.appendNewLine;

public class Board {
    private int pieceCount = 0;

    private List<Piece> whitePawns = new ArrayList<Piece>();
    private List<Piece> blackPawns = new ArrayList<Piece>();
    private List<Piece> whitePieces = new ArrayList<Piece>();
    private List<Piece> blackPieces = new ArrayList<Piece>();


    public void addWhitePawn(Piece pawn) {
        if (!pawn.getColor().equals(Piece.WHITE_COLOR)) {
            throw new InvalidParameterException("The color of this pawn must be white.");
        }
        pieceCount++;
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Piece pawn) {
        if (!pawn.getColor().equals(Piece.BLACK_COLOR)) {
            throw new InvalidParameterException("The color of this pawn must be black.");
        }
        pieceCount++;
        blackPawns.add(pawn);
    }

    public void addWhitePiece(Piece piece) {
        pieceCount++;
        whitePieces.add(piece);
    }

    public void addBlackPiece(Piece piece) {
        pieceCount++;
        blackPieces.add(piece);
    }


    public int pieceCount() {
        return pieceCount;
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

    public Piece findWhitePiece(int index) {
        if (whitePawns.size() < index + 1) {
            throw new InvalidParameterException("The index must be equal to or less than the size of the whitePawns.");
        }
        return whitePieces.get(index);
    }

    public Piece findBlackPiece(int index) {
        if (blackPawns.size() < index + 1) {
            throw new InvalidParameterException("The index must be equal to or less than the size of the whitePawns.");
        }
        return blackPieces.get(index);
    }


    public void initialize() {
        int boardSize = 8;
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
        for (int i = 0; i < boardSize; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    public String getWhitePawnsResult() {
        StringBuilder whiteResult = new StringBuilder();

        for (Piece whitePawn : whitePawns) {
            whiteResult.append(whitePawn.getRepresentation());
        }
        return whiteResult.toString();

    }

    public String getBlackPawnsResult() {
        StringBuilder blackResult = new StringBuilder();

        for (Piece blackPawn : blackPawns) {
            blackResult.append(blackPawn.getRepresentation());
        }
        return blackResult.toString();
    }

    public String getWhitePiecesResult() {
        StringBuilder whiteResult = new StringBuilder();

        for (Piece whitePiece : whitePieces) {
            whiteResult.append(whitePiece.getRepresentation());
        }
        return whiteResult.toString();

    }

    public String getBlackPiecesResult() {
        StringBuilder blackResult = new StringBuilder();

        for (Piece blackPiece : blackPieces) {
            blackResult.append(blackPiece.getRepresentation());
        }
        return blackResult.toString();
    }

    private String emptyLine() {
        String emptyLine = "........";
        return emptyLine;
    }

    public String showBoard() {
        StringBuilder printResult = new StringBuilder();
        printResult.append(appendNewLine(getBlackPiecesResult()));
        printResult.append(appendNewLine(getBlackPawnsResult()));
        printResult.append(appendNewLine(emptyLine()));
        printResult.append(appendNewLine(emptyLine()));
        printResult.append(appendNewLine(emptyLine()));
        printResult.append(appendNewLine(emptyLine()));
        printResult.append(appendNewLine(getWhitePawnsResult()));
        printResult.append(appendNewLine(getWhitePiecesResult()));
        return printResult.toString();
    }

}
