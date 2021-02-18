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

<<<<<<< HEAD
        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            blackPieceList.add(Piece.createBlackPawn());
        }
=======
<<<<<<< HEAD
    public void add(Pawn pawn) {
        pawnList.add(pawn);
>>>>>>> 3c74074... feat : Do Mission2
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

<<<<<<< HEAD
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
=======
        Pawn pawn = pawnList.get(listIndex);
=======
    public void add(Pawn pawnColor) {
        pawnList.add(pawnColor);
    }

    public int size() {
        return pawnList.size();
    }

    public Pawn findPawn(int i) {

        Pawn pawn = pawnList.get(i);
>>>>>>> feat : Do Mission2
>>>>>>> 3c74074... feat : Do Mission2

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
