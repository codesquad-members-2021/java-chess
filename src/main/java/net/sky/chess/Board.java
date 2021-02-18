package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceType;

public class Board {

    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private int pieceCount = 0;

    public void addWhitePawn(Piece piece) {
        whitePawns.add(piece);
    }

    public void addBlackPawn(Piece piece) {
        blackPawns.add(piece);
    }

    public void addWhitePiece(Piece piece) {
        whitePieces.add(piece);
    }

    public void addBlackPiece(Piece piece) {
        blackPieces.add(piece);
    }

    public void initialize() {
        initializePawns();
        initializePieces();
    }

    private void initializePawns() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(Piece.createPiece(Color.WHITE, PieceType.PAWN));
            addBlackPawn(Piece.createPiece(Color.BLACK, PieceType.PAWN));
        }
    }

    private void initializePieces() {
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.ROOK));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.KNIGHT));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.BISHOP));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.QUEEN));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.KING));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.BISHOP));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.KNIGHT));
        addWhitePiece(Piece.createPiece(Color.WHITE, PieceType.ROOK));

        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.ROOK));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.KNIGHT));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.BISHOP));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.QUEEN));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.KING));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.BISHOP));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.KNIGHT));
        addBlackPiece(Piece.createPiece(Color.BLACK, PieceType.ROOK));
    }

    public String getPiecesResult(List<Piece> pieces) {
        StringBuilder result = new StringBuilder();
        for (Piece piece : pieces) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }

    public void print() {
        System.out.println(showBoard());
    }

    public int pieceCount() {
        return pieceCount;
    }

    public String showBoard() {
        String blankLine = "........";
        StringBuilder result = new StringBuilder();

        result.append(appendNewLine(getPiecesResult(blackPieces)));
        result.append(appendNewLine(getPiecesResult(blackPawns)));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(blankLine));
        result.append(appendNewLine(getPiecesResult(whitePawns)));
        result.append(appendNewLine(getPiecesResult(whitePieces)));

        return result.toString();
    }
}
