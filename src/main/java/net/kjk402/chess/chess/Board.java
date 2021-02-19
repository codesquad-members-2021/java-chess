package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Piece;

import static net.kjk402.chess.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Piece> whitePawnList = new ArrayList<>();
    private final List<Piece> blackPawnList = new ArrayList<>();
    private final List<Piece> whitePiecesList = new ArrayList<>();
    private final List<Piece> blackPiecesList = new ArrayList<>();

    public void addWhitePawn(Piece piece) {
        if (piece.getColor() == Piece.WHITE) {
            whitePawnList.add(piece);
        }
    }

    public void addBlackPawn(Piece piece) {
        if (piece.getColor() == Piece.BLACK) {
            blackPawnList.add(piece);
        }
    }

    public void addWhitePiece(Piece piece) {
        if (piece.getColor() == Piece.WHITE) {
            whitePiecesList.add(piece);
        }
    }

    public void addBlackPiece(Piece piece) {
        if (piece.getColor() == Piece.BLACK) {
            blackPiecesList.add(piece);
        }
    }

    public int whiteSize() {
        return whitePawnList.size();
    }

    public int blackSize() {
        return blackPawnList.size();
    }

    public Piece findWhitePawn(int idx) {
        return whitePawnList.get(idx);
    }

    public Piece findBlackPawn(int idx) {
        return blackPawnList.get(idx);
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Piece(Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION));
            addBlackPawn(new Piece(Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION));
        }
        setWhitePieces();
        setBlackPieces();
    }

    public void setWhitePieces() {
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }

    public void setBlackPieces() {
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
        return getPiecesResult(whitePawnList);
    }

    public String getBlackPawnsResult() {
        return getPiecesResult(blackPawnList);
    }

    public String getWhitePiecesResult() {
        return getPiecesResult(whitePiecesList);
    }

    public String getBlackPiecesResult() {
        return getPiecesResult(blackPiecesList);
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public void print() {
        StringBuilder boardOutput = new StringBuilder();
        boardOutput.append(appendNewLine(getBlackPiecesResult()));
        boardOutput.append(appendNewLine(getBlackPawnsResult()));
        boardOutput.append(appendNewLine("........"));
        boardOutput.append(appendNewLine("........"));
        boardOutput.append(appendNewLine("........"));
        boardOutput.append(appendNewLine("........"));
        boardOutput.append(appendNewLine(getWhitePawnsResult()));
        boardOutput.append(appendNewLine(getWhitePiecesResult()));
        System.out.println(boardOutput.toString());
    }

}
