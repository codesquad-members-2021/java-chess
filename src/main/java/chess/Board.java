package chess;

import chess.pieces.Piece;
import chess.pieces.Color;
import chess.pieces.PieceName;

import java.util.ArrayList;
import java.util.List;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    private static final int PAWNSNUM = 8;
    private List<Piece> whitePawns = new ArrayList<>(8);
    private List<Piece> blackPawns = new ArrayList<>(8);
    private List<Piece> whitePieces = new ArrayList<>(8);
    private List<Piece> blackPieces = new ArrayList<>(8);

    private List<Piece> distinguish(Piece piece) {
        if (piece.getColor() == Color.WHITE && piece.getName() == PieceName.PAWN) {
            return whitePawns;
        }
        if (piece.getColor() == Color.BLACK && piece.getName() == PieceName.PAWN) {
            return blackPawns;
        }
        if (piece.getColor() == Color.WHITE && piece.getName() != PieceName.PAWN) {
            return whitePieces;
        }
        if (piece.getColor() == Color.BLACK && piece.getName() != PieceName.PAWN) {
            return blackPieces;
        }
        return null;
    }

    public void add(Piece piece) {
        distinguish(piece).add(piece);
    }

    public int size(Piece piece) {
        return distinguish(piece).size();
    }

    public Piece findPiece(Piece piece, int idx) {
        return distinguish(piece).get(idx);
    }

    public void initialize() {
        initBlackPiece();
        initBlackPawn();
        initWhitePawn();
        initWhitePiece();
    }

    private void initBlackPiece() {
        add(Piece.createBlackRook());
        add(Piece.createBlackKnight());
        add(Piece.createBlackBishop());
        add(Piece.createBlackQueen());
        add(Piece.createBlackKing());
        add(Piece.createBlackBishop());
        add(Piece.createBlackKnight());
        add(Piece.createBlackRook());
    }

    private void initWhitePiece() {
        add(Piece.createWhiteRook());
        add(Piece.createWhiteKnight());
        add(Piece.createWhiteBishop());
        add(Piece.createWhiteQueen());
        add(Piece.createWhiteKing());
        add(Piece.createWhiteBishop());
        add(Piece.createWhiteKnight());
        add(Piece.createWhiteRook());
    }

    private void initWhitePawn() {
        for (int i = 0; i < PAWNSNUM; i++) {
            add(Piece.createWhitePawn());
        }
    }

    private void initBlackPawn() {
        for (int i = 0; i < PAWNSNUM; i++) {
            add(Piece.createBlackPawn());
        }
    }

    public int pieceCount() {
        return whitePawns.size() + whitePieces.size() +
                blackPawns.size() + blackPieces.size();
    }

    public String showBoard() {
        String empty = appendNewLine(getEmptyResult());
        return appendNewLine(getBlackPieceResult()) +
                appendNewLine(getBlackPawnResult()) +
                empty + empty + empty + empty +
                appendNewLine(getWhitePawnResult()) +
                appendNewLine(getWhitePieceResult());
    }

    private String getEmptyResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < PAWNSNUM; i++) {
            result.append(".");
        }
        return result.toString();
    }

    private String getWhitePawnResult() {
        return getPieceResult(whitePawns);
    }

    private String getBlackPawnResult() {
        return getPieceResult(blackPawns);
    }

    private String getWhitePieceResult() {
        return getPieceResult(whitePieces);
    }

    private String getBlackPieceResult() {
        return getPieceResult(blackPieces);
    }

    private String getPieceResult(List<Piece> pieces) {
        StringBuilder result = new StringBuilder();
        for (Piece piece : pieces) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }
}
