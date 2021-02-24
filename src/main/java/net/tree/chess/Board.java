package net.tree.chess;

import net.tree.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static net.utils.StringUtils.appendNewLine;

public class Board {

    private List<Piece> whitePieceList = new ArrayList<>();
    private List<Piece> blackPieceList = new ArrayList<>();
    private final int BOARD_SIZE = 8;
    private String blankDot = "........";

    public void initialize() {
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

    //전체 피스 개수 세어주는 메소드
    public int pieceCount() {
        return whitePieceList.size() + blackPieceList.size();
    }

    //보드 프린트하는 메소드
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getExceptPawnPieces(blackPieceList)));
        sb.append(appendNewLine(getPawnPieces(blackPieceList)));
        sb.append(appendNewLine(blankDot));
        sb.append(appendNewLine(blankDot));
        sb.append(appendNewLine(blankDot));
        sb.append(appendNewLine(blankDot));
        sb.append(appendNewLine(getPawnPieces(whitePieceList)));
        sb.append(appendNewLine(getExceptPawnPieces(whitePieceList)));

        return sb.toString();
    }

    public String getExceptPawnPieces(List<Piece> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++) {
            String tempRepresentation = Character.toString(list.get(i).getRepresentation());
            if(! tempRepresentation.toLowerCase().equals("p")) {
                sb.append(list.get(i).getRepresentation());
            }
        }
        return sb.toString();
    }

    public String getPawnPieces(List<Piece> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size() ; i++) {
            String tempRepresentation = Character.toString(list.get(i).getRepresentation());
            if(tempRepresentation.toLowerCase().equals("p")) {
                sb.append(list.get(i).getRepresentation());
            }
        }
        return sb.toString();
    }


}
