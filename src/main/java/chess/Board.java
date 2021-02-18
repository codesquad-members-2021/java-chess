package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int MAX_PAWN = 8;

    private final List<Piece> blackPawns  = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> whitePawns  = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();

    public boolean addBlackPawn(Piece pawn) {
        return blackPawns.add(pawn);
    }

    public boolean addWhitePawn(Piece pawn) {
        return whitePawns.add(pawn);
    }

    public int pieceCount() { // 전체 기물의 개수를 반환한다.
        return blackPawns.size() + whitePawns.size() + blackPieces.size() + whitePieces.size();
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
        blackPieces.addAll(Arrays.asList(
                Piece.createBlackRook()
                , Piece.createBlackKnight()
                , Piece.createBlackBishop()
                , Piece.createBlackQueen()
                , Piece.createBlackKing()
                , Piece.createBlackBishop()
                , Piece.createBlackKnight()
                , Piece.createBlackRook())
        );
    }

    private void addBlackPawns() {
        for (int i = 0; i < Board.MAX_PAWN; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }
    }

    private void addWhitePieces() {
        whitePieces.addAll(Arrays.asList(
                Piece.createWhiteRook()
                , Piece.createWhiteKnight()
                , Piece.createWhiteBishop()
                , Piece.createWhiteQueen()
                , Piece.createWhiteKing()
                , Piece.createWhiteBishop()
                , Piece.createWhiteKnight()
                , Piece.createWhiteRook())
        );
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

        chessBoard.append(appendNewLine(getPieceResult(blackPieces)))
                .append(appendNewLine(getPieceResult(blackPawns)))
                .append(blankRank + blankRank + blankRank + blankRank)
                .append(appendNewLine(getPieceResult(whitePawns)))
                .append(appendNewLine(getPieceResult(whitePieces)));

        return chessBoard.toString();
    }

    private String getPieceResult(final List<Piece> pieces) {
        StringBuilder piecesRepresentations = new StringBuilder();
        pieces.stream()
                .map(piece -> piece.getRepresentation())
                .forEach(piecesRepresentations::append);
        return piecesRepresentations.toString();
    }
}
