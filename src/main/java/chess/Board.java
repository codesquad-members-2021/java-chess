package chess;

import pieces.Piece;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private static final int BOARD_SIZE = 8;
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void initializeWhitePieces() {
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }

    private void initializeBlackPieces() {
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    public void addWhitePiece(Piece piece) {
        if (checkPieceColor(piece, Piece.WHITE_COLOR))
            whitePieces.add(piece);
    }

    public void addBlackPiece(Piece piece) {
        if (checkPieceColor(piece, Piece.BLACK_COLOR))
            blackPieces.add(piece);
    }

    public void addWhitePawn(Piece pawn) {
        if (checkPieceColor(pawn, Piece.WHITE_COLOR))
            whitePawns.add(pawn);
    }

    public void addBlackPawn(Piece pawn) {
        if (checkPieceColor(pawn, Piece.BLACK_COLOR))
            blackPawns.add(pawn);
    }

    private boolean checkPieceColor(Piece piece, String color) {
        return piece.getColor().equals(color);
    }

    public String getWhitePawnsResult() {
        return getPiecesRepresentations(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPiecesRepresentations(blackPawns);
    }

    public String getWhitePiecesResult() {
        return getPiecesRepresentations(whitePieces);
    }

    public String getBlackPiecesResult() {
        return getPiecesRepresentations(blackPieces);
    }

    private String getPiecesRepresentations(List<Piece> pieces) {
        StringBuilder piecesResult = new StringBuilder();
        for (Piece piece : pieces)
            piecesResult.append(piece.getRepresentation());
        return piecesResult.toString();
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public int size() {
        return blackPawns.size() + whitePawns.size();
    }

    public String printBoard() {
        return "a";
    }
}
