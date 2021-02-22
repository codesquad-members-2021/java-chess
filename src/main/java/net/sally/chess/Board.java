package net.sally.chess;

import net.sally.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import static net.sally.util.StringUtils.*;

public class Board {
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public static int BOARD_SIZE = 8;
    private static final String BLANK = "........";

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            whitePawns.add(Piece.createWhitePawn());
            blackPawns.add(Piece.createBlackPawn());
        }
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());

        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());
    }

    public String getWhitePawnsResult() {
        return getPiecesResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPiecesResult(blackPawns);
    }

    public String getWhitePiecesResult() { return getPiecesResult(whitePieces); }

    public String getBlackPiecesResult() { return getPiecesResult(blackPieces); }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder piecesResult = new StringBuilder();
        for (Piece p : pieces) {
            piecesResult.append(p.getRepresentation());
        }
        return piecesResult.toString();
    }

    public int getWhitePawnSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public int getWhitePiecesSize() { return whitePieces.size(); }

    public int getBlackPiecesSize() { return blackPieces.size(); }

    public int pieceCount() { return getBlackPawnsSize() + getWhitePawnSize() + getWhitePiecesSize() + getBlackPiecesSize(); }

    public String showBoard() {
        StringBuilder printer = new StringBuilder();
        printer.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));
        return printer.toString();
    }
}
