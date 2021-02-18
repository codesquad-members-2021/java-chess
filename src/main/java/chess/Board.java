package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {

    private final List<Piece> pieceList = new ArrayList<>();

    private final int FILES = 8;

    private void addBlackPawns() {
        for (int i = 0; i < FILES; i++) {
            pieceList.add(Piece.createBlackPawn());
        }
    }

    private void addWhitePawns() {
        for (int i = 0; i < FILES; i++) {
            pieceList.add(Piece.createWhitePawn());
        }
    }

    private void addBlackPieces() {
        pieceList.add(Piece.createBlackRook());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackQueen());
        pieceList.add(Piece.createBlackKing());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackRook());
    }

    private void addWhitePieces() {
        pieceList.add(Piece.createWhiteRook());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteQueen());
        pieceList.add(Piece.createWhiteKing());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteRook());
    }

    private String getPiecesResult(int row) {
        StringBuilder pieceResult = new StringBuilder();
        for (Piece piece : this.pieceList.subList(row * FILES, row * FILES + FILES)) {
            pieceResult.append(piece.getRepresentation());
        }
        return pieceResult.toString();
    }

    public void initialize() {
        addBlackPieces();
        addBlackPawns();
        addWhitePawns();
        addWhitePieces();
    }

    public String showBoard() {
        StringBuilder output = new StringBuilder();
        String blankRank = appendNewLine("........");
        output.append(appendNewLine(getPiecesResult(0)));
        output.append(appendNewLine(getPiecesResult(1)));
        output.append(blankRank).append(blankRank).append(blankRank).append(blankRank);
        output.append(appendNewLine(getPiecesResult(2)));
        output.append(appendNewLine(getPiecesResult(3)));
        return output.toString();
    }

    public int pieceCount() {
        return pieceList.size();
    }

}
