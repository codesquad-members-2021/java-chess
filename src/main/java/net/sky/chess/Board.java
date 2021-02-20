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
        pieceCount++;
    }

    public void addBlackPawn(Piece piece) {
        blackPawns.add(piece);
        pieceCount++;
    }

    public void addWhitePiece(Piece piece) {
        whitePieces.add(piece);
        pieceCount++;
    }

    public void addBlackPiece(Piece piece) {
        blackPieces.add(piece);
        pieceCount++;
    }

    public void initialize() {
        initializeWhitePawns();
        initializeBlackPawns();
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void initializeWhitePawns() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(Piece.getPawnInstance(Color.WHITE));
        }
    }

    private void initializeBlackPawns() {
        for (int i = 0; i < 8; i++) {
            addBlackPawn(Piece.getPawnInstance(Color.BLACK));
        }
    }

    private void initializeWhitePieces() {
        addWhitePiece(Piece.getRookInstance(Color.WHITE));
        addWhitePiece(Piece.getKnightInstance(Color.WHITE));
        addWhitePiece(Piece.getBishopInstance(Color.WHITE));
        addWhitePiece(Piece.getQueenInstance(Color.WHITE));
        addWhitePiece(Piece.getKingInstance(Color.WHITE));
        addWhitePiece(Piece.getBishopInstance(Color.WHITE));
        addWhitePiece(Piece.getKnightInstance(Color.WHITE));
        addWhitePiece(Piece.getRookInstance(Color.WHITE));
    }

    private void initializeBlackPieces() {
        addBlackPiece(Piece.getRookInstance(Color.BLACK));
        addBlackPiece(Piece.getKnightInstance(Color.BLACK));
        addBlackPiece(Piece.getBishopInstance(Color.BLACK));
        addBlackPiece(Piece.getQueenInstance(Color.BLACK));
        addBlackPiece(Piece.getKingInstance(Color.BLACK));
        addBlackPiece(Piece.getBishopInstance(Color.BLACK));
        addBlackPiece(Piece.getKnightInstance(Color.BLACK));
        addBlackPiece(Piece.getRookInstance(Color.BLACK));
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

    public int pieceCount() {
        return pieceCount;
    }
}
