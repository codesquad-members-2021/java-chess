package net.tree.chess;

import net.tree.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    private static final int BOARD_SIZE = 8;
    private static final String LINE = "........";
    public static final int TOTAL_PIECES_SIZE = 32;

    public void initializeAllPieces() {
        initializeWhitePieces();
        initializeBlackPieces();
    }

    public void initializeWhitePieces() {
        whitePieces.add(Piece.createWhiteRook());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteQueen());
        whitePieces.add(Piece.createWhiteKing());
        whitePieces.add(Piece.createWhiteBishop());
        whitePieces.add(Piece.createWhiteKnight());
        whitePieces.add(Piece.createWhiteRook());

        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            whitePieces.add(Piece.createWhitePawn());
        }
    }

    public void initializeBlackPieces() {
        blackPieces.add(Piece.createBlackRook());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackQueen());
        blackPieces.add(Piece.createBlackKing());
        blackPieces.add(Piece.createBlackBishop());
        blackPieces.add(Piece.createBlackKnight());
        blackPieces.add(Piece.createBlackRook());

        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            blackPieces.add(Piece.createBlackPawn());
        }
    }

    public int countAllPieces() {
        return whitePieces.size() + blackPieces.size();
    }

    public String createInitializedBoard() {
        StringBuilder board = new StringBuilder();
        board.append(appendNewLine(getFirstAndEighthRankPiecesByList(blackPieces)));
        board.append(appendNewLine(getPawnPiecesByList(blackPieces)));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(getPawnPiecesByList(whitePieces)));
        board.append(appendNewLine(getFirstAndEighthRankPiecesByList(whitePieces)));

        return board.toString();
    }

    //getExceptPawnPiecesByList 이런 식으로 작명했었는데, Exception과 혼동이 온다고 수정했습니다.
    public String getFirstAndEighthRankPiecesByList(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : pieces) {
            Character tempChar = Character.toLowerCase(piece.getRepresentation());
            if( tempChar != 'p') {
                sb.append(piece.getRepresentation());
            }
        }
        return sb.toString();
    }

    public String getPawnPiecesByList(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : pieces) {
            Character tempChar = Character.toLowerCase(piece.getRepresentation());
            if( tempChar == 'p') {
                sb.append(piece.getRepresentation());
            }
        }
        return sb.toString();
    }


}
