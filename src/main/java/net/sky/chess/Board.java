package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;

public class Board {

    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private final PieceMaker whitePieceMaker = new PieceMaker(Color.WHITE);
    private final PieceMaker blackPieceMaker = new PieceMaker(Color.BLACK);

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
        initializeWhitePawns();
        initializeBlackPawns();
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void initializeWhitePawns() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(whitePieceMaker.createPawn());
        }
    }

    private void initializeBlackPawns() {
        for (int i = 0; i < 8; i++) {
            addBlackPawn(blackPieceMaker.createPawn());
        }
    }

    private void initializeWhitePieces() {
        addWhitePiece(whitePieceMaker.createRook());
        addWhitePiece(whitePieceMaker.createKnight());
        addWhitePiece(whitePieceMaker.createBishop());
        addWhitePiece(whitePieceMaker.createQueen());
        addWhitePiece(whitePieceMaker.createKing());
        addWhitePiece(whitePieceMaker.createBishop());
        addWhitePiece(whitePieceMaker.createKnight());
        addWhitePiece(whitePieceMaker.createRook());
    }

    private void initializeBlackPieces() {
        addBlackPiece(blackPieceMaker.createRook());
        addBlackPiece(blackPieceMaker.createKnight());
        addBlackPiece(blackPieceMaker.createBishop());
        addBlackPiece(blackPieceMaker.createQueen());
        addBlackPiece(blackPieceMaker.createKing());
        addBlackPiece(blackPieceMaker.createBishop());
        addBlackPiece(blackPieceMaker.createKnight());
        addBlackPiece(blackPieceMaker.createRook());
    }

    private String getPiecesResult(List<Piece> pieces) {
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
        return whitePawns.size() + blackPawns.size() + whitePieces.size() + blackPieces.size();
    }
}
