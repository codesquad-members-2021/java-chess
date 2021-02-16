package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

public class Board {

    private final List<Piece> blackPawnList = new ArrayList<>();
    private final List<Piece> blackOtherPieceList = new ArrayList<>();
    private final List<Piece> whitePawnList = new ArrayList<>();
    private final List<Piece> whiteOtherPieceList = new ArrayList<>();

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
        blackOtherPieceList.add(Piece.createBlackRook());
        blackOtherPieceList.add(Piece.createBlackKnight());
        blackOtherPieceList.add(Piece.createBlackBishop());
        blackOtherPieceList.add(Piece.createBlackQueen());
        blackOtherPieceList.add(Piece.createBlackKing());
        blackOtherPieceList.add(Piece.createBlackBishop());
        blackOtherPieceList.add(Piece.createBlackKnight());
        blackOtherPieceList.add(Piece.createBlackRook());
    }

    private void addWhitePieces() {
        whiteOtherPieceList.add(Piece.createWhiteRook());
        whiteOtherPieceList.add(Piece.createWhiteKnight());
        whiteOtherPieceList.add(Piece.createWhiteBishop());
        whiteOtherPieceList.add(Piece.createWhiteQueen());
        whiteOtherPieceList.add(Piece.createWhiteKing());
        whiteOtherPieceList.add(Piece.createWhiteBishop());
        whiteOtherPieceList.add(Piece.createWhiteKnight());
        whiteOtherPieceList.add(Piece.createWhiteRook());
    }

    private String getPieceResult(List<Piece> pieceList) {
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
        output.append(appendNewLine(getPieceResult(blackOtherPieceList)));
        output.append(appendNewLine(getPieceResult(blackPawnList)));
        output.append(blankRank).append(blankRank).append(blankRank).append(blankRank);
        output.append(appendNewLine(getPieceResult(whitePawnList)));
        output.append(appendNewLine(getPieceResult(whiteOtherPieceList)));
        return output.toString();
    }

    public int pieceCount() {
        return blackPawnList.size() + whitePawnList.size()
                + blackOtherPieceList.size() + whiteOtherPieceList.size();
    }

}
