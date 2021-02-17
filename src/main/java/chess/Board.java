package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int MAX_PAWN = 8;

    private final List<Piece> blackPawns = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> whitePawns = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();

    public boolean addBlackPawn(Piece pawn) {
        return blackPawns.add(pawn);
    }

    public boolean addWhitePawn(Piece pawn) {
        return whitePawns.add(pawn);
    }

    public boolean addBlackPiece(Piece piece) {
        return blackPieces.add(piece);
    }

    public boolean addWhitePiece(Piece piece) {
        return whitePieces.add(piece);
    }

    public int pieceCount() { // 전체 기물의 개수를 반환한다.
        return blackPawns.size() + whitePawns.size() + blackPieces.size() + whitePieces.size();
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    /* 체스판을 초기화한다. */
    public void initialize() {
        blackPawns.removeAll(blackPawns);
        whitePawns.removeAll(whitePawns);
        blackPieces.removeAll(blackPieces);
        whitePieces.removeAll(whitePieces);

        addBlackPieces();
        addBlackPawns();
        addWhitePawns();
        addWhitePieces();
    }

    private void addBlackPieces() {
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    private void addBlackPawns() {
        for (int i = 0; i < Board.MAX_PAWN; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }
    }

    private void addWhitePieces() {
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }

    private void addWhitePawns() {
        for (int i = 0; i < Board.MAX_PAWN; i++) {
            addWhitePawn(Piece.createWhitePawn());
        }
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환한다. */
    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();
        String blankRank = appendNewLine("........");
        chessBoard.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(blankRank)
                .append(blankRank)
                .append(blankRank)
                .append(blankRank)
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));

        return chessBoard.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder blackPawnRepresentations = new StringBuilder();

        for (Piece black : blackPawns) {
            blackPawnRepresentations.append(black.getRepresentation());
        }

        return blackPawnRepresentations.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder whitePawnRepresentations = new StringBuilder();

        for (Piece white : whitePawns) {
            whitePawnRepresentations.append(white.getRepresentation());
        }

        return whitePawnRepresentations.toString();
    }

    public String getBlackPiecesResult() {
        StringBuilder blackPieceRepresentations = new StringBuilder();

        for (Piece black : blackPieces) {
            blackPieceRepresentations.append(black.getRepresentation());
        }

        return blackPieceRepresentations.toString();
    }

    public String getWhitePiecesResult() {
        StringBuilder whitePieceRepresentations = new StringBuilder();

        for (Piece white : whitePieces) {
            whitePieceRepresentations.append(white.getRepresentation());
        }

        return whitePieceRepresentations.toString();
    }
}
