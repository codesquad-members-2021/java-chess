package chess;

import chess.pieces.Piece;


import java.util.ArrayList;
import java.util.List;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_RANK = 8;
    private List<Rank> board = new ArrayList<>(BOARD_RANK);


    public void initialize() {
        initBlackPieceRank();
        initBlackPawnRank();
        for(int i = 0; i < 4; i++) {
            initBlankRank();
        }
        initWhitePawnRank();
        initWhitePieceRank();
    }

    private void initBlackPieceRank() {
        Rank rank1 = new Rank(1);
        rank1.add(Piece.createBlackRook());
        rank1.add(Piece.createBlackKnight());
        rank1.add(Piece.createBlackBishop());
        rank1.add(Piece.createBlackQueen());
        rank1.add(Piece.createBlackKing());
        rank1.add(Piece.createBlackBishop());
        rank1.add(Piece.createBlackKnight());
        rank1.add(Piece.createBlackRook());
    }

    private void initWhitePieceRank() {
        add(Piece.createWhiteRook());
        add(Piece.createWhiteKnight());
        add(Piece.createWhiteBishop());
        add(Piece.createWhiteQueen());
        add(Piece.createWhiteKing());
        add(Piece.createWhiteBishop());
        add(Piece.createWhiteKnight());
        add(Piece.createWhiteRook());
    }

    private void initWhitePawnRank() {
        for (int i = 0; i < BOARD_RANK; i++) {
            add(Piece.createWhitePawn());
        }
    }

    private void initBlackPawnRank() {
        for (int i = 0; i < BOARD_RANK; i++) {
            add(Piece.createBlackPawn());
        }
    }

    private void initBlankRank(){
        
    }

    public int pieceCount() {
        return whitePawns.size() + whitePieces.size() +
                blackPawns.size() + blackPieces.size();
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        String empty = appendNewLine(getEmptyResult());
        result.append(appendNewLine(getBlackPieceResult()))
                .append(appendNewLine(getBlackPawnResult()))
                .append(empty + empty + empty + empty)
                .append(appendNewLine(getWhitePawnResult()))
                .append(appendNewLine(getWhitePieceResult()));
        return result.toString();
    }

    private String getEmptyResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < BOARD_RANK; i++) {
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
