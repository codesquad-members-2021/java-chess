package chess;

import chess.pieces.Piece;
import chess.pieces.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int PAWNSNUM = 8;
    private static final int COLUMN = 8;
    private List<Piece> whitePawns = new ArrayList<>(8);
    private List<Piece> blackPawns = new ArrayList<>(8);
    private List<Piece> whitePieces = new ArrayList<>(8);
    private List<Piece> blackPieces = new ArrayList<>(8);


    private List<Piece> distinguishPawn(Piece pawn) {
        if (pawn.getColor() == Color.WHITE) {
            return whitePawns;
        }
        return blackPawns;
    }

    public void addPawn(Piece pawn) {
        distinguishPawn(pawn).add(pawn);
    }

    public int pawnSize(Piece pawn) {
        return distinguishPawn(pawn).size();
    }

    public Piece findPawn(Piece pawn, int idx) {
        return distinguishPawn(pawn).get(idx);
    }

    private List<Piece> distinguishPiece(Piece piece) {
        if (piece.getColor() == Color.WHITE) {
            return whitePieces;
        }
        return blackPieces;
    }

    public void addPiece(Piece piece) {
        distinguishPiece(piece).add(piece);
    }

    public int pieceSize(Piece piece) {
        return distinguishPiece(piece).size();
    }

    public Piece findPiece(Piece piece, int idx) {
        return distinguishPiece(piece).get(idx);
    }

    public void initialize() {

    }

    public int pieceCount() {

    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        String empty = getEmptyResult();

        return result.toString();
    }

    public String getEmptyResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < PAWNSNUM; i++) {
            result.append(".");
        }
        return result.toString();
    }

    public String getWhitePawnResult() {
        return getPawnResult(whitePawns);
    }

    public String getBlackPawnResult() {
        return getPawnResult(blackPawns);
    }

    private String getPawnResult(List<Piece> pawns) {
        StringBuilder result = new StringBuilder();
        for (Piece pawn : pawns) {
            result.append(pawn.getRepresentation());
        }
        return result.toString();
    }
}
