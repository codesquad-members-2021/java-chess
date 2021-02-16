package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {

    private final List<Piece> blackPawnList = new ArrayList<>();
    private final List<Piece> otherBlackPieceList = new ArrayList<>();
    private final List<Piece> whitePawnList = new ArrayList<>();
    private final List<Piece> otherWhitePieceList = new ArrayList<>();

    private final int FILES = 8;

    private void addBlackPawns() {
        for (int i = 0; i < FILES; i++) {
            blackPawnList.add(Piece.createBlackPawn());
        }
    }

    private void addWhitePawns() {
        for (int i = 0; i < FILES; i++) {
            whitePawnList.add(Piece.createWhitePawn());
        }
    }

    private void addBlackPieces() {
        otherBlackPieceList.add(Piece.createBlackRook());
        otherBlackPieceList.add(Piece.createBlackKnight());
        otherBlackPieceList.add(Piece.createBlackBishop());
        otherBlackPieceList.add(Piece.createBlackQueen());
        otherBlackPieceList.add(Piece.createBlackKing());
        otherBlackPieceList.add(Piece.createBlackBishop());
        otherBlackPieceList.add(Piece.createBlackKnight());
        otherBlackPieceList.add(Piece.createBlackRook());
    }

    private void addWhitePieces() {
        otherWhitePieceList.add(Piece.createWhiteRook());
        otherWhitePieceList.add(Piece.createWhiteKnight());
        otherWhitePieceList.add(Piece.createWhiteBishop());
        otherWhitePieceList.add(Piece.createWhiteQueen());
        otherWhitePieceList.add(Piece.createWhiteKing());
        otherWhitePieceList.add(Piece.createWhiteBishop());
        otherWhitePieceList.add(Piece.createWhiteKnight());
        otherWhitePieceList.add(Piece.createWhiteRook());
    }

    private String getPiecesResult(List<Piece> pieceList) {
        StringBuilder pieceResult = new StringBuilder();
        for (Piece piece : pieceList) {
            pieceResult.append(piece.getRepresentation());
        }
        return pieceResult.toString();
    }

    public void initialize() {
        addBlackPawns();
        addWhitePawns();
        addBlackPieces();
        addWhitePieces();
    }

    public String showBoard() {
        StringBuilder output = new StringBuilder();
        String blankRank = appendNewLine("........");
        output.append(appendNewLine(getPiecesResult(otherBlackPieceList)));
        output.append(appendNewLine(getPiecesResult(blackPawnList)));
        output.append(blankRank).append(blankRank).append(blankRank).append(blankRank);
        output.append(appendNewLine(getPiecesResult(whitePawnList)));
        output.append(appendNewLine(getPiecesResult(otherWhitePieceList)));
        return output.toString();
    }

    public int pieceCount() {
        return blackPawnList.size() + whitePawnList.size()
                + otherBlackPieceList.size() + otherWhitePieceList.size();
    }

}
