package net.honux.chess;

import static net.honux.chess.utils.StringUtils.appendNewLine;

import net.honux.chess.pieces.Piece;

import java.util.ArrayList;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private ArrayList<Piece> whitePawns = new ArrayList<>();
    private ArrayList<Piece> whitePieces = new ArrayList<>();
    private ArrayList<Piece> blackPawns = new ArrayList<>();
    private ArrayList<Piece> blackPieces = new ArrayList<>();

    public void add(Piece pawn) {
        distinguishPawnsColor(pawn).add(pawn);
    }

    public int size(Piece pawn) {
        return distinguishPawnsColor(pawn).size();
    }

    public Piece findPawn(Piece pawn, int index) {
        return distinguishPawnsColor(pawn).get(index);
    }

    private ArrayList<Piece> distinguishPawnsColor(Piece pawn) {
        if (pawn.getColor() == Piece.WHITE_COLOR)
            return whitePawns;
        else
            return blackPawns;
    }

    void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            whitePawns.add(new Piece(Piece.WHITE_COLOR, Piece.White.PAWN.representation));
            blackPawns.add(new Piece(Piece.BLACK_COLOR, Piece.Black.PAWN.representation));
        }
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.ROOK.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.KNIGHT.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.BISHOP.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.QUEEN.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.KING.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.BISHOP.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.KNIGHT.representation));
        whitePieces.add(new Piece(Piece.WHITE_COLOR, Piece.White.ROOK.representation));

        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.ROOK.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.KNIGHT.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.BISHOP.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.QUEEN.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.KING.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.BISHOP.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.KNIGHT.representation));
        blackPieces.add(new Piece(Piece.BLACK_COLOR, Piece.Black.ROOK.representation));
    }

    public String getWhitePawnsResult() {
        return listPawnsToSingleLine(whitePawns);
    }

    public String getBlackPawnsResult() {
        return listPawnsToSingleLine(blackPawns);
    }

    public String getBlankLine() {
        return "........";
    }

    private String listPiecesToSingleLine(ArrayList<Piece> pieces) {
        StringBuilder sb = new StringBuilder();

        for (Piece p : pieces)
            sb.append(p.getRepresentation());

        return sb.toString();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlackPiecesResult()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getWhitePiecesResult()));
        return sb.toString();
    }
}

