package net.tree.chess;

import net.tree.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.utils.StringUtils.appendNewLine;

public class Board {

    private List<Piece> whitePieceList = new ArrayList<>();
    private List<Piece> blackPieceList = new ArrayList<>();

    private static final int BOARD_SIZE = 8;
    private static final String LINE = "........";
    public static final int TOTAL_PIECES_SIZE = 32;


    public void initializeAllPieces() {
        initializeWhitePieces();
        initializeBlackPieces();
    }

    public void initializeWhitePieces() {
        whitePieceList.add(Piece.createWhiteRook());
        whitePieceList.add(Piece.createWhiteKnight());
        whitePieceList.add(Piece.createWhiteBishop());
        whitePieceList.add(Piece.createWhiteQueen());
        whitePieceList.add(Piece.createWhiteKing());
        whitePieceList.add(Piece.createWhiteBishop());
        whitePieceList.add(Piece.createWhiteKnight());
        whitePieceList.add(Piece.createWhiteRook());

        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            whitePieceList.add(Piece.createWhitePawn());
        }
    }

    public void initializeBlackPieces() {
        blackPieceList.add(Piece.createBlackRook());
        blackPieceList.add(Piece.createBlackKnight());
        blackPieceList.add(Piece.createBlackBishop());
        blackPieceList.add(Piece.createBlackQueen());
        blackPieceList.add(Piece.createBlackKing());
        blackPieceList.add(Piece.createBlackBishop());
        blackPieceList.add(Piece.createBlackKnight());
        blackPieceList.add(Piece.createBlackRook());

        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            blackPieceList.add(Piece.createBlackPawn());
        }
    }

    public int countAllPieces() {
        return whitePieceList.size() + blackPieceList.size();
    }

    public String showBoard() {
        StringBuilder board = new StringBuilder();
        board.append(appendNewLine(getFirstAndEighthRankPiecesByList(blackPieceList)));
        board.append(appendNewLine(getPawnPiecesByList(blackPieceList)));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(LINE));
        board.append(appendNewLine(getPawnPiecesByList(whitePieceList)));
        board.append(appendNewLine(getFirstAndEighthRankPiecesByList(whitePieceList)));

        return board.toString();
    }

    //getExceptPawnPiecesByList 이런 식으로 작명했었는데, Exception과 혼동이 온다고 수정
    public String getFirstAndEighthRankPiecesByList(List<Piece> pieceList) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < pieceList.size() ; i++) {
            Character tempChar = Character.toLowerCase(pieceList.get(i).getRepresentation());
            if( tempChar != 'p') {
                sb.append(pieceList.get(i).getRepresentation());
            }
        }
        return sb.toString();
    }

    public String getPawnPiecesByList(List<Piece> pieceList) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pieceList.size() ; i++) {
            Character tempChar = Character.toLowerCase(pieceList.get(i).getRepresentation());
            if( tempChar == 'p') {
                sb.append(pieceList.get(i).getRepresentation());
            }
        }
        return sb.toString();
    }




}
